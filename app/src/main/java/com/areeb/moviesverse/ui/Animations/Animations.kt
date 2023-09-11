import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.expandVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.areeb.moviesverse.R
import kotlinx.coroutines.delay

@Composable
fun NetflixIntroAnimation() {
    var showText by remember { mutableStateOf(false) }
    var scale by remember { mutableStateOf(0.2f) }
    var alpha by remember { mutableStateOf(0.0f) }

    LaunchedEffect(key1 = showText) {
        delay(300) // Delay for 500 milliseconds before showing the text
        showText = true
    }

    val scaleAnim by animateFloatAsState(
        targetValue = if (showText) 1.6f else 3.0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessLow,
        ),
    )

    val alphaAnim by animateFloatAsState(
        targetValue = if (showText) 1.0f else 0.0f,
        animationSpec = tween(durationMillis = 500),
    )

    Box(
        modifier = Modifier.padding(10.dp),
        contentAlignment = Alignment.Center,
    ) {
        AnimatedVisibility(
            visible = showText,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(3000),
            ) + expandVertically(
                expandFrom = Alignment.Top,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "MoviesVerse",
                modifier = Modifier
                    .scale(scaleAnim)
                    .padding(top = 20.dp)
                    .graphicsLayer(
                        alpha = alphaAnim,
                    ),
                color = colorResource(id = R.color.blood_red),
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.SansSerif,
            )
        }
    }
}
