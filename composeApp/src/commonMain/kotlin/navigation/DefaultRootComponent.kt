package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import kotlinx.serialization.Serializable
import navigation.RootComponent.Child
import navigation.RootComponent.Config

interface RootComponent {
    fun navigateToOnboarding()
    fun navigateToLogin()
    fun navigateToHome(arguments: String = "Default arguments")
    fun navigateToDiary()
    fun navigateToFavorites()

    @Serializable
    sealed class Config {
        @Serializable
        data object Onboarding : Config()

        @Serializable
        data object Login : Config()

        @Serializable
        data class Home(val info: String) : Config()

        @Serializable
        data object Favorites : Config()

        @Serializable
        data object Diary : Config()
    }

    sealed class Child {
        data class Onboarding(val component: OnboardingComponent) : Child()
        data class Login(val component: LoginComponent) : Child()
        data class Home(val component: HomeComponent) : Child()
        data class Favorites(val component: FavoritesComponent) : Child()
        data class Diary(val component: DiaryComponent) : Child()
    }
}

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    val childStack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Onboarding,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(config: Config, context: ComponentContext): Child {
        return when (config) {
            is Config.Onboarding -> Child.Onboarding(
                OnboardingComponent(
                    context,
                    { navigation.bringToFront(Config.Login) },
                    { navigation.pop() }
                )
            )
            is Config.Login -> Child.Login(
                LoginComponent(
                    context,
                    { navigation.bringToFront(Config.Home("Uh yeah")) },
                    { navigation.pop() }
                )
            )
            is Config.Favorites -> Child.Favorites(
                FavoritesComponent(
                    context,
                    { navigation.bringToFront(Config.Diary) },
                    { navigation.pop() }
                )
            )
            is Config.Diary -> Child.Diary(
                DiaryComponent(
                    context,
                    { navigation.bringToFront(Config.Favorites) },
                    { navigation.pop() }
                )
            )
            is Config.Home -> Child.Home(
                HomeComponent(
                    config.info,
                    context,
                    { navigation.bringToFront(Config.Onboarding) },
                    { navigation.pop() }
                )
            )
        }
    }

    override fun navigateToOnboarding() {
        navigation.bringToFront(Config.Onboarding)
    }

    override fun navigateToLogin() {
        navigation.bringToFront(Config.Login)
    }

    override fun navigateToHome(arguments: String) {
        navigation.bringToFront(Config.Home(arguments))
    }

    override fun navigateToDiary() {
        navigation.bringToFront(Config.Diary)
    }

    override fun navigateToFavorites() {
        navigation.bringToFront(Config.Favorites)
    }
}