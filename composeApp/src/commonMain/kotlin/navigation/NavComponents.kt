package navigation

import com.arkivanov.decompose.ComponentContext

/**
 * these components act as kind of ViewModels, therefore they can hold states
 */
class OnboardingComponent(
    componentContext: ComponentContext,
    onNavigate: () -> Unit,
    onNavigateBack: () -> Unit
): BaseComponent(onNavigate, onNavigateBack), ComponentContext by componentContext {
}

class LoginComponent(
    componentContext: ComponentContext,
    onNavigate: () -> Unit,
    onNavigateBack: () -> Unit
) : BaseComponent(onNavigate, onNavigateBack), ComponentContext by componentContext {

}

class HomeComponent(
    val info: String,
    componentContext: ComponentContext,
    onNavigate: () -> Unit,
    onNavigateBack: () -> Unit
) : BaseComponent(onNavigate, onNavigateBack), ComponentContext by componentContext {

}

class DiaryComponent(
    componentContext: ComponentContext,
    onNavigate: () -> Unit,
    onNavigateBack: () -> Unit
) : BaseComponent(onNavigate, onNavigateBack), ComponentContext by componentContext {

}

class FavoritesComponent(
    componentContext: ComponentContext,
    onNavigate: () -> Unit,
    onNavigateBack: () -> Unit
) : BaseComponent(onNavigate, onNavigateBack), ComponentContext by componentContext {

}

abstract class BaseComponent(
    val onNavigate: () -> Unit,
    val onNavigateBack: () -> Unit
) {
    fun onEvent() {
        onNavigate.invoke()
    }
}