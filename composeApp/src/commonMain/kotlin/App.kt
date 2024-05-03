import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import navigation.BottomBar
import navigation.DefaultRootComponent
import navigation.RootComponent
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.DiaryScreen
import screens.FavoritesScreen
import screens.HomeScreen
import screens.LoginScreen
import screens.OnboardingScreen

@Composable
@Preview
fun App(rootComponent: DefaultRootComponent) {
        MaterialTheme {
            val stack by rootComponent.childStack.subscribeAsState()

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                Children(
                    stack = stack,
                    modifier = Modifier,
                    animation = stackAnimation(fade())
                ) {
                    when (val child = it.instance) {
                        is RootComponent.Child.Home -> {
                            HomeScreen(child.component)
                        }

                        is RootComponent.Child.Onboarding -> {
                            OnboardingScreen(child.component)
                        }

                        is RootComponent.Child.Login -> {
                            LoginScreen(child.component)
                        }

                        is RootComponent.Child.Diary -> {
                            DiaryScreen(child.component)
                        }
                        is RootComponent.Child.Favorites -> {
                            FavoritesScreen(child.component)
                        }
                    }
                }

                BottomBar(rootComponent, modifier = Modifier)
            }


//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
    }
}