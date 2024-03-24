package com.example.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                CreateBizCard()
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)) {
                Column(modifier = Modifier
                    .height(900.dp)
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CreateProfileImage()
                    Divider(modifier = Modifier.paddingFromBaseline(15.dp))
                    CreateInfo()
                    CreatePortfolio()
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Content() {
    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .fillMaxHeight()) {
        Surface(modifier = Modifier
            .padding(5.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            border = BorderStroke(width = 5.dp, color = Color.Gray),
            color = Color.White) {
                Portfolio(data = listOf("Project 1", "Project 2", "Project 3", "Project 4"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) {item ->
            Text(text = item)
        }
    }
}


@Composable
private fun CreatePortfolio() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Button(modifier = Modifier.padding(20.dp), onClick = {
        buttonClickedState.value = !buttonClickedState.value
    }) {
        Text(
            text = "Portfolio",
            style = MaterialTheme.typography.displayMedium,
            fontSize = 15.sp
        )
    }
    if(buttonClickedState.value) {
        Content()
    }
    else {

    }
}

@Composable
private fun CreateInfo(modifier: Modifier = Modifier) {
    Column(modifier = modifier.paddingFromBaseline(40.dp)) {
        Text(
            text = "Atharva Vijay Khade",
            color = Color.Gray,
            fontSize = 25.sp
        )
        Text(
            text = "Android Compose Programmer",
            color = Color.Black,
            fontSize = 15.sp
        )
        Text(
            text = "@atharvaCompose",
            color = Color.Black,
            fontSize = 15.sp
        )
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        shape = CircleShape,
        color = Color.Green,
        border = BorderStroke(0.5.dp, Color.Black),
        modifier = modifier
            .size(150.dp)
            .padding(5.dp)
            .shadow(20.dp, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}