package com.example.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hello.ui.theme.HelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HelloApp( modifier: Modifier = Modifier) {
    var showHelloWorld by remember { mutableStateOf(false) }
    Surface(modifier.fillMaxSize()) {
        if(showHelloWorld){
            HelloWorldScreen(onOkClicked = { showHelloWorld = false })
        } else {
            HelloScreen(onHelloClicked = { showHelloWorld = true })
        }
    }
}

@Composable
fun HelloScreen(onHelloClicked: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = onHelloClicked){
            Text("Hello")
        }
    }
}

@Composable
fun HelloWorldScreen(onOkClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello World", modifier = Modifier.padding(bottom = 16.dp))
        Button(onClick = onOkClicked) {
            Text("OK")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloScreenPreview() {
    HelloTheme {
        HelloScreen(onHelloClicked = {})
    }
}

@Preview(showBackground = true)
@Composable
fun HelloWorldScreenPreview() {
    HelloTheme {
        HelloWorldScreen(onOkClicked = {})
    }
}

@Preview
@Composable
fun HelloAppPreview() {
    HelloTheme {
        HelloApp(Modifier.fillMaxSize())
    }
}