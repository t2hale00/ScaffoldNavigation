package com.example.scaffold

import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scaffold.ui.theme.ScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationExampleApp()
                }
            }
        }
    }
}


@Composable
fun NavigationExampleApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
       composable(route = "home") {
           HomeScreen(navController)
       }
        composable(route= "second") {
            SecondScreen(navController)
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "This is second screen")
        Button(onClick = { navController.navigateUp() }
        ) {
            Text(text = "Back to Home")
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "This is home screen")
        Button(
            onClick = { navController.navigate("second") }
        ) {
            Text(text = "To second")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScaffoldTheme {
        NavigationExampleApp()
    }
}