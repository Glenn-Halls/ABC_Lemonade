package com.example.lemonade
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
                }
            }
        }
    }

@Composable
fun LemonadeApp() {

    // Counter for current state of lemon / lemonade
    var state by remember { mutableStateOf(1) }

    // Counter for number of squeezes applied to lemon
    var squeezeCount by remember { mutableStateOf(0) }

    // Run function ImageAndText with appropriate arguments
    when (state) {
        1 -> {
            // Display lemon tree, ask user to pick lemon
            ImageAndText(
                textResourceId = R.string.tap_tree,
                imageResourceId = R.drawable.lemon_tree,
                imageDescriptionId = R.string.image_lemon_tree
            ) {
                state++
                squeezeCount = (2..4).random()
            }
        }
        2 -> {
            // Display lemon, ask user to squeeze
            ImageAndText(
                textResourceId = R.string.keep_tapping,
                imageResourceId = R.drawable.lemon_squeeze,
                imageDescriptionId = R.string.image_lemon
            ) {
                squeezeCount--
                if (squeezeCount == 0) {
                    state++
                }
            }
        }
        3 -> {
            // Display lemonade, ask user to drink
            ImageAndText(
                textResourceId = R.string.tap_lemonade,
                imageResourceId = R.drawable.lemon_drink,
                imageDescriptionId = R.string.image_glass_full
            ) {
                state++
            }
        }
        4 -> {
            // Display empty glass, ask user to restart
            ImageAndText(
                textResourceId = R.string.tap_glass,
                imageResourceId = R.drawable.lemon_restart,
                imageDescriptionId = R.string.image_glass_empty
            ) {
                state = 1
            }
        }
    }
}

@Composable
fun ImageAndText(
    textResourceId: Int,
    imageResourceId: Int,
    imageDescriptionId: Int,
    actionOnClick: () -> Unit
) {
    val borderColor = Color(105, 205, 216)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(textResourceId),
            style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = stringResource(imageDescriptionId),
            modifier = Modifier
                .clickable(onClick = actionOnClick)
                .border(
                    BorderStroke(2.dp, borderColor),
                    RoundedCornerShape(4.dp)
                )
        )

    }
}

@Preview(showBackground = true)
@Composable
fun LemonPreview() {
    LemonadeApp()
}

