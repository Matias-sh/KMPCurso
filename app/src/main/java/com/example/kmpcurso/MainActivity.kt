package com.example.kmpcurso

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmpcurso.ui.theme.KMPCursoTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KMPCursoTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main() {
    var isTextClicked by remember { mutableStateOf(false) } Scaffold { paddingValues -> // Use Scaffold for padding handling
        Card(
            modifier = Modifier
                .padding(paddingValues) // Apply Scaffold padding
                .fillMaxSize() // Make Card fill the screen
                .clickable {
                    isTextClicked = !isTextClicked
                    Log.d("Click", "$isTextClicked")
                },
            shape = RoundedCornerShape(20),
            elevation = CardDefaults.cardElevation(15.dp),
            border = BorderStroke(1.dp, Color.Red)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(), // Make Column fill the Card
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // ... Your existing Row content ...
            }
        }
    }
}

@Composable
fun Main() {
    var isTextClicked by remember { mutableStateOf(false) }
    Scaffold { paddingValues ->
        20.dp
        Card(
            modifier = Modifier
                .padding(paddingValues) // Apply Scaffold padding
                .fillMaxSize()
                .clickable {
                    isTextClicked = !isTextClicked
                    Log.d("Click", "$isTextClicked")
                }.wrapContentSize(),
            shape = RoundedCornerShape(20),
            elevation = CardDefaults.cardElevation(15.dp),
            border = BorderStroke(1.dp, Color.Red)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = if (isTextClicked) painterResource(id = R.drawable.baseline_person_24) else painterResource(
                            id = R.drawable.baseline_mouse_24
                        ),
                        contentDescription = "Perfil"
                    )
                    CustomText(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color.Gray),
                        texto = if (isTextClicked) "Hola Matias" else "Hola",
                        fontSize = 30.sp
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = if (isTextClicked) painterResource(id = R.drawable.baseline_person_24) else painterResource(
                            id = R.drawable.baseline_mouse_24
                        ),
                        contentDescription = "Perfil"
                    )
                    CustomText(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color.Gray),
                        texto = if (isTextClicked) "Hola Matias" else "Hola",
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

@Composable
fun CustomText(modifier: Modifier, texto: String, fontSize: TextUnit) {
    Text(
        modifier = modifier,
        text = texto,
        color = Color.Green,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun CustomPreview() {
    KMPCursoTheme {
        Main()
    }
}