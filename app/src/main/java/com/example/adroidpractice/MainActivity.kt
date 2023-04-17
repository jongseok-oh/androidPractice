package com.example.adroidpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adroidpractice.ui.theme.AdroidPracticeTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdroidPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    BirthdayGreetingWithText(message = "종석아 생일 축하해 ^^7", from = "김치찌개")
                }
            }
        }
    }
}

// Composable는 아무것도 반환할 수 없다.
// xml 안쓰고 compose로 선언형 프로그래밍 쌉가능
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
     Surface(){
        Text(
            text = "Hi, my name is $name!",
            modifier = Modifier.padding(24.dp)
            // Modifier로 Composable를 강화 or 장식 가능
        )
    }
}

@Composable
fun BirthdayGreetingWithText(message : String, from : String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = message,
            fontSize = 36.sp
        )
        Text(
            text = "from : $from",
            fontSize = 36.sp
        )
    }
}

@Preview(name = "My Preview",
        showSystemUi = true)
@Composable
fun DefaultPreview() {
    AdroidPracticeTheme {
        BirthdayGreetingWithText("종석아 생일 축하해 ^^7", "김치찌개")
    }
}