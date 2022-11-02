package com.mobile.savannah_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mobile.savannah_demo.ui.theme.AndroidTheme

class KotlinActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = intent.extras;
        val counts: ArrayList<Int>? = args?.getIntegerArrayList("counts")
        setContent {
            AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    DefaultPreview(counts)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


//@Preview(showBackground = true)
@Composable
fun DefaultPreview(counts: ArrayList<Int>?) {
    AndroidTheme {
        Scaffold(
                topBar = {
                    TopAppBar(
                            title = {
                                Text(text = "Kotlin Page")
                            },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = Color.White,
                            elevation = 10.dp
                    )
                }, content = {
            Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                            painterResource(R.drawable.kotlin),
                            contentDescription = null,
                            modifier = Modifier.requiredSize(50.dp)
                    )
                    Text(text = "You opened Kotlin Page ${counts?.get(0)} times")

                }

                Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                            painterResource(R.drawable.flutter),
                            contentDescription = null,
                            modifier = Modifier.requiredSize(50.dp)
                    )
                    Text(text = "You opened Second Page ${counts?.get(1)} times")

                }

                Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                            painterResource(R.drawable.main),
                            contentDescription = null,
                            modifier = Modifier.requiredSize(50.dp)
                    )
                    Text(text = "You opened Main Page ${counts?.get(2)} times")

                }
            }

        })


    }


}


