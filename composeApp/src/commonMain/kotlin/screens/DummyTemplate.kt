package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DummyTemplate(modifier: Modifier = Modifier, screenTitle: String) {
    Column(modifier = modifier) {
        Spacer(Modifier.height(32.dp))

        Text(
            text = screenTitle,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 24.sp
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "This is some dummy looooooooooong text to fill the screen with some dumb stuff. yyyoooooo lets gooooo",
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun DummyTemplate_Preview() {

}