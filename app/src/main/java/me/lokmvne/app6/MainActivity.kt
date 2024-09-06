package me.lokmvne.app6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.compose.App6Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { _: Uri? ->
//        Toast.makeText(this, "Image Selected", Toast.LENGTH_SHORT).show()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartActivityForResult(),
                onResult = {
                    if (it.resultCode == RESULT_OK) {
                        val sum = it.data?.getIntExtra("sum", 0)
                        Toast.makeText(this, "The sum is: $sum", Toast.LENGTH_SHORT).show()
                    }
                }
            )
            App6Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        val intent = Intent(this@MainActivity, MainActivity2::class.java).apply {
                            putExtra("num1", 10)
                            putExtra("num2", 20)
                        }
//                        startActivityForResult(intent, 1)
                        launcher.launch(intent)
                    }) {
                        Text(text = "start Activity")
                    }
                }
            }
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            val sum = data?.getIntExtra("sum", 0)
//            Toast.makeText(this, "The sum is: $sum", Toast.LENGTH_SHORT).show()
//        }
//    }
}