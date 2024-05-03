package screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.LoginComponent

@Composable
fun LoginScreen(component: LoginComponent) {
    Row {
    Text("LOGIN")
        Button(onClick = { component.onEvent() }) {
            Text("Navigate")
        }
    }
}
