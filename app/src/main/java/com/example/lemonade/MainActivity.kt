package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    lemonedApp()
                }
            }
        }
    }
}

@Composable
fun lemonedApp(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(0) }
    var stateText by remember { mutableStateOf(0) }
    var textImage = stringResource(id = R.string.lemon_tree)
    var imageLemoned = painterResource(id = R.drawable.lemon_tree)
    when (state) {
        0 -> imageLemoned = painterResource(id = R.drawable.lemon_tree)
        1 -> imageLemoned = painterResource(id = R.drawable.lemon_squeeze)
        2 -> imageLemoned = painterResource(id = R.drawable.lemon_drink)
        3 -> imageLemoned = painterResource(id = R.drawable.lemon_restart)
    }
    when (stateText) {
        0 -> textImage = stringResource(id = R.string.lemon_tree)
        1 -> textImage = stringResource(id = R.string.lemon)
        2 -> textImage = stringResource(id = R.string.drink)
        3 -> textImage = stringResource(id = R.string.empty)

    }


    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = textImage,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(16.dp))


        Image(
            painter = imageLemoned,
            contentDescription = stringResource(id = R.string.lemon_tree),
            Modifier.clickable {

                if (state == 1) {
                    var squeeze = (2..4).random()

                }
                stateText++
                state++

            } )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        lemonedApp()
    }
}