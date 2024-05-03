package screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.HomeComponent

@Composable
fun HomeScreen(component: HomeComponent) {
    Row {
        Text("HOME")
        Button(onClick = { component.onEvent() }) {
            Text("Navigate")
        }
    }
}