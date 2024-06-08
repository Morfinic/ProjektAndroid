package com.example.projektandroid.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projektandroid.chat.BluetoothDevice
import com.example.projektandroid.view.BluetoothUiState


@Composable
fun ScanScreen(
    state: BluetoothUiState,
    onDeviceClick: (BluetoothDevice) -> Unit,
    stopScan: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn {
            item {
                Text(
                    text = "Scanned devices",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }

            items(state.scannedDevices){ device ->
                Text(
                    text = device.name ?: "No name",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onDeviceClick(device) }
                        .padding(16.dp)
                )
            }
        }
        
        Button(
            onClick = stopScan,
            modifier = Modifier
                .padding(
                    start = 5.dp,
                    end = 5.dp
                )
                .fillMaxWidth(),
            shape = RoundedCornerShape(0),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Text(text = "Stop scanning")
        }
    }
}
