package navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState

@Composable
fun BottomBar(rootComponent: DefaultRootComponent, modifier: Modifier = Modifier) {
    val childStack by rootComponent.childStack.subscribeAsState()
    val currentSelected = childStack.active.instance

    BottomNavigation(modifier = modifier) {
        BottomNavigationItem(
            selected = currentSelected is RootComponent.Child.Home,
            rootComponent::navigateToHome,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                )
            }
        )
        BottomNavigationItem(
            selected = currentSelected is RootComponent.Child.Favorites,
            rootComponent::navigateToFavorites,
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorites",
                )
            }
        )
        BottomNavigationItem(
            selected = currentSelected is RootComponent.Child.Diary,
            rootComponent::navigateToDiary,
            icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Diary",
                )
            }
        )
    }

}