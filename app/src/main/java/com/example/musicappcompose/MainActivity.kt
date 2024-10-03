package com.example.musicappcompose

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val configuration = LocalConfiguration.current
            when (configuration.orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    MusicAppHorizontal()
                }

                else -> {
                    MusicAppVertical()
                }
            }
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@Preview(
    showBackground = true, showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=landscape"
)
@Composable
fun MusicAppHorizontal() {
    var MusicaSonando by remember { mutableStateOf(false) }
    var BarraBolumen by remember { mutableStateOf(0.7f) }
    var BarraCancion by remember { mutableStateOf(0.25f) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Slider(
                value = BarraBolumen,
                onValueChange = { newValue -> BarraBolumen = newValue },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(R.drawable.song2),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
        }

        Column(
            modifier = Modifier.weight(2f)
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Song2")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Blur")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("1:00")
                Slider(
                    value = BarraCancion,
                    onValueChange = { newValue -> BarraCancion = newValue },
                    valueRange = 0f..1f,
                    modifier = Modifier.weight(1f)
                )
                Text("3:00")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(android.R.drawable.ic_media_previous),
                    contentDescription = "Previous",
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.width(60.dp))

                Image(
                    painter = painterResource(
                        if (MusicaSonando) android.R.drawable.ic_media_pause
                        else android.R.drawable.ic_media_play
                    ),
                    contentDescription = if (MusicaSonando) "Pause" else "Play",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            MusicaSonando = !MusicaSonando
                        }
                )

                Spacer(modifier = Modifier.width(60.dp))

                Image(
                    painter = painterResource(android.R.drawable.ic_media_next),
                    contentDescription = "Next",
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(android.R.drawable.ic_menu_share),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.width(60.dp))

                Image(
                    painter = painterResource(android.R.drawable.ic_menu_sort_alphabetically),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.width(60.dp))

                Image(
                    painter = painterResource(android.R.drawable.ic_menu_sort_by_size),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MusicAppVertical() {
    var MusicaSonando by remember { mutableStateOf(false) }
    var BarraBolumen by remember { mutableStateOf(0.7f) }
    var BarraCancion by remember { mutableStateOf(0.25f) }

    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        Row {
            Slider(
                value = BarraBolumen,
                onValueChange = { newValue -> BarraBolumen = newValue },
                valueRange = 0f..1f,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row {
            Image(
                painter = painterResource(R.drawable.song2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Song2")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Blur")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("1:00")
            Slider(
                value = BarraCancion,
                onValueChange = { newValue -> BarraCancion = newValue },
                valueRange = 0f..1f,
                modifier = Modifier.weight(1f)
            )
            Text("3:00")
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(android.R.drawable.ic_media_previous),
                contentDescription = "Previous",
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.width(30.dp))

            Image(
                painter = painterResource(
                    if (MusicaSonando) android.R.drawable.ic_media_play
                    else android.R.drawable.ic_media_pause
                ),
                contentDescription = if (MusicaSonando) "Pause" else "Play",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        MusicaSonando = !MusicaSonando
                    }
            )

            Spacer(modifier = Modifier.width(30.dp))

            Image(
                painter = painterResource(android.R.drawable.ic_media_next),
                contentDescription = "Next",
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(android.R.drawable.ic_menu_share),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.width(30.dp))

            Image(
                painter = painterResource(android.R.drawable.ic_menu_sort_alphabetically),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.width(30.dp))

            Image(
                painter = painterResource(android.R.drawable.ic_menu_sort_by_size),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

