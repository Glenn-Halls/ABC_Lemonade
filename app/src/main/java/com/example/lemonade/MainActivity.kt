package com.example.lemonade
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
                // A surface container using the 'background' color from the theme
                LemonadeApp()
                }
            }
        }
    }

@Composable
fun ShowImage() {

    val borderColor = Color(105, 205, 216)


    var state by remember { mutableStateOf(1) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
    ) {
        Text(
            text = "hello",
            style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.lemon_tree),
            contentDescription = "TBD",
            modifier = Modifier
                .clickable(onClick = {
                    state = (1..4).random()
                })
                .border(2.dp, borderColor, RoundedCornerShape(4.dp))
        )

    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    ShowImage()
}

