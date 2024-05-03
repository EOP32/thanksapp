package screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.FavoritesComponent

@Composable
fun FavoritesScreen(component: FavoritesComponent) {
    Row {
        Text("FAVORITES")
        Button(onClick = { component.onEvent() }) {
            Text("Navigate")
        }
    }
}