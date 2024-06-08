package com.example.projektandroid.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projektandroid.chat.BluetoothDevice
import com.example.projektandroid.ui.theme.OldRose
import com.example.projektandroid.ui.theme.Plum
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
                .padding(12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "appIcon",
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = "Bt-Chat",
                fontSize = 25.sp
            )
        }

        HorizontalDivider(
            thickness = 2.dp,
            color = Color.Black,
            modifier = Modifier.padding(
                start = 5.dp,
                end = 5.dp
            )
        )

        BluetoothDeviceList(
            pairedDevices = state.pairedDevices,
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
                    .padding(1.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(0)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "addIcon",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "Add device")
            }

            Button(
                onClick = onStartServer,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(1.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(0)
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "callIcon",
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "Await chat")
            }
        }
    }
}

@Composable
fun BluetoothDeviceList(
    pairedDevices: List<BluetoothDevice>,
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
                modifier = Modifier.padding(8.dp)
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
    }
}