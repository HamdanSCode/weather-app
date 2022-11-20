package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherModel: WeatherViewModel by viewModels()
        Log.v("Hamdan", "STATUS VALUE: ${weatherModel.status.value}")
        setContent {
            BackgroundImage(id = R.drawable.clear_sky)
            Column(
                Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.15f)
                        .background(Color.Red)
                        .padding(0.dp)
                        .padding(12.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        sectionText(text = "Day")
                    }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        sectionText(text = "Week")
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.35f)
                        .background(Color.Yellow)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray), horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "11/20/2022",
                            textAlign = TextAlign.Center,
                        )
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Red),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            Modifier
                                .background(Color.Gray)
                        ) {
                            Row(
                                Modifier
                                    .background(Color.Green),
                            ) {
                                Text(text = "58", fontSize = 80.sp, textAlign = TextAlign.Center)
                                Text(text = "°", fontSize = 80.sp)
                            }
                            Row() {
                                Text(text = "H:63°", fontSize = 20.sp)
                                Text(text = "L:63°", fontSize = 20.sp)
                            }
                        }

                    }
                }
//                Row(modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(1f)
//                    .background(Color.Gray)){
//                    Column(
//                        Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        Text(text = "HELLO")
//                    }
//                    Column(
//                        Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        Text(text = "HELLO")
//                    }
//                    Column(
//                        Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        Text(text = "HELLO")
//                    }
//                    Column(
//                        Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        Text(text = "HELLO")
//                    }
//                }

            }
        }
    }
}

@Composable
fun BackgroundImage(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun sectionText(text: String) {
    Text(
        text = text,
        Modifier
            .fillMaxWidth(.6f)
            .clip(RoundedCornerShape(32.dp))
            .background(Color.Magenta)
            .padding(horizontal = 12.dp)
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}