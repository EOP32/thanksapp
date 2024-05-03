package screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.DiaryComponent

@Composable
fun DiaryScreen(component: DiaryComponent) {
    Row {
        Text("DIARY")
        Button(onClick = { component.onEvent() }) {
            Text("Navigate")
        }
    }
}