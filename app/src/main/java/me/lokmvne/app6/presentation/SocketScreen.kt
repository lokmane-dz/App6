package me.lokmvne.app6.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SocketScreen() {
    val viewModel = hiltViewModel<SocketScreenViewModel>()
    var message = viewModel.message.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Socket Demo", modifier = Modifier.weight(1f))

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.fillMaxWidth(),
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onSendMessage(message)
                    message = ""
                }
            ) {
                Text(text = "Send Message")
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onConnect()
                }
            ) {
                Text(text = "Connect Socket")
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onDisconnect()
                }
            ) {
                Text(text = "Disconnect Socket")
            }
        }
    }
}