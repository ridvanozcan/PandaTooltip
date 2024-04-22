package com.github.pandatooltip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.panda.Panda
import com.github.pandatooltip.ui.theme.PandaTooltipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PandaTooltipTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var pandaState by remember { mutableStateOf(true) }

                    Column(Modifier.fillMaxSize()) {
                        Panda(
                            modifier = Modifier,
                            pandaState = pandaState,
                            backgroundColor = Color.Gray,
                            content = { modifier ->
                                Text(
                                    modifier = modifier
                                        .background(Color.LightGray)
                                        .padding(12.dp),
                                    text = "Click - Tooltip Bottom"
                                )
                            },
                            tooltipContent = {
                                Text(
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp)
                                        .padding(vertical = 8.dp),
                                    text = "Tooltip Example",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        lineHeight = 18.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.White
                                    ),
                                )
                            }, onDismissRequest = {
                                pandaState = it
                            })

                        Spacer(modifier = Modifier.weight(1f))

                        Panda(
                            modifier = Modifier,
                            pandaState = pandaState,
                            backgroundColor = Color.Red,
                            content = { modifier ->
                                Text(
                                    modifier = modifier
                                        .background(Color.LightGray)
                                        .padding(12.dp),
                                    text = "Click - Tooltip Top"
                                )
                            },
                            tooltipContent = {
                                Text(
                                    modifier = Modifier
                                        .padding(horizontal = 12.dp)
                                        .padding(vertical = 8.dp),
                                    text = "Tooltips text with Panda Panda Panda \n Panda Panda Panda Panda",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        lineHeight = 18.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.White
                                    ),
                                )
                            },
                            onDismissRequest = {
                                pandaState = it
                            })
                    }
                }
            }
        }
    }
}