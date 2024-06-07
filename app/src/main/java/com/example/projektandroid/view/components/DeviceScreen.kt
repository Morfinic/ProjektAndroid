package com.example.projektandroid.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projektandroid.chat.BluetoothDevice
import com.example.projektandroid.view.BluetoothUiState

@Composable
fun DeviceScreen(
    state: BluetoothUiState,
    onStartScan: () -> Unit,
    onStartServer: () -> Unit,
    onDeviceClick: (BluetoothDevice) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "appIcon"
            )
            Text(
                text = "Bt-Chat",
                modifier = Modifier.weight(1f)
            )
        }

        BluetoothDeviceList(
            pairedDevices = state.pairedDevices,
//            scannedDevices = state.scannedDevices,
            onClick = onDeviceClick,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = onStartScan,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(1.dp)
            ) {
                Text(text = "Add device")
            }

            Button(
                onClick = onStartServer,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(1.dp)
            ) {
                Text(text = "Await chat")
            }
        }
    }
}

@Composable
fun BluetoothDeviceList(
    pairedDevices: List<BluetoothDevice>,
//    scannedDevices: List<BluetoothDevice>,
    onClick: (BluetoothDevice) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                text = "Paired devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(pairedDevices){ device ->
            Text(
                text = device.name ?: "(No name)",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(device) }
                    .padding(16.dp)
            )

        }

//        item {
//            Text(
//                text = "Scanned devices",
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp,
//                modifier = Modifier.padding(16.dp)
//            )
//        }
//
//        items(scannedDevices){ device ->
//            Text(
//                text = device.name ?: "No name",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { onClick(device) }
//                    .padding(16.dp)
//            )
//
//        }
    }
}