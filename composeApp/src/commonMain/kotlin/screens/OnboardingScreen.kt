package screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import navigation.OnboardingComponent

@Composable
fun OnboardingScreen(component: OnboardingComponent) {
    Row {
        Text("Onboarding".uppercase())
        Button(onClick = { component.onEvent() }) {
            Text("Navigate")
        }
    }
}