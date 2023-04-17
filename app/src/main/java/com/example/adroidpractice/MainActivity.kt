package com.example.adroidpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
                    BirthdayGreetingWithText(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "from : $from",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(end = 16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message : String, from : String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)

    Box{
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

@Composable
fun ComposeTutorial(){
    val image = painterResource(R.drawable.bg_compose_background)

    Column{
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(R.string.Jetpack_compose_tutorial_subject),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.Jetpack_compose_tutorial_short_description),
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.Jetpack_compose_tutorial_long_description),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManager(){

    val image = painterResource(R.drawable.ic_task_completed)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp
        )
    }
}

@Composable
fun OneRect(subject: String, decoration: String, color: Color, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = color)
            .fillMaxSize()
    ) {
        Text(
            text= subject,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text= decoration,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeQuadrant(){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            OneRect(
                subject = "Text composable",
                decoration = "Displays text and follows Material Design guidelines.",
                color = Color.Green,
                modifier = Modifier.weight(1f)
            )
            OneRect(
                subject = "Image composable",
                decoration = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)){
            OneRect(
                subject = "Row composable",
                decoration = "A layout composable that places its children in a horizontal sequence.",
                color = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            OneRect(
                subject = "Column composable",
                decoration = "A layout composable that places its children in a vertical sequence.",
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(name = "My Preview",
        showSystemUi = true)
@Composable
fun DefaultPreview() {
    AdroidPracticeTheme {
        //BirthdayGreetingWithText("종석아 생일 축하해 ^^7", "김치찌개")
        //BirthdayGreetingWithImage("종석아 생일 축하해 ^^7", "김치찌개")
        //ComposeTutorial()
        //TaskManager
        ComposeQuadrant()
    }
}

