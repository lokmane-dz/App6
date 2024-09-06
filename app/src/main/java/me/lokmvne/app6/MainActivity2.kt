package me.lokmvne.app6

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.compose.App6Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App6Theme {
                val num1 = intent.getIntExtra("num1", 0)
                val num2 = intent.getIntExtra("num2", 0)
                SecondScreen(onclick = {
                    val sum = num1 + num2
                    val ResultIntent = Intent().apply {
                        putExtra("sum", sum)
                    }
                    setResult(RESULT_OK, ResultIntent)
                    finish()
                })
            }
        }
    }
}

@Composable
fun SecondScreen(onclick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                onclick()
            }
        ) {
            Text(text = "Return Result")
        }
    }
}