package com.example.projektandroid.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projektandroid.chat.BluetoothMessage
import com.example.projektandroid.ui.theme.OldRose
import com.example.projektandroid.ui.theme.Plum
import com.example.projektandroid.ui.theme.ProjektAndroidTheme
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun ChatMessage(
    message: BluetoothMessage,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
//            .clip(
//                RoundedCornerShape(
//                    topStart = if (message.isFromLocalUser) 15.dp else 0.dp,
//                    topEnd = 15.dp,
//                    bottomStart = 15.dp,
//                    bottomEnd = if (message.isFromLocalUser) 0.dp else 15.dp
//                )
//            )
            .background(
//                if (message.isFromLocalUser) OldRose else Vanilla
                Color.White
            )
            .padding(
                5.dp
            )
    ) {
        Text(
            text = message.senderName +
                    " " +
                    SimpleDateFormat("HH:mm:ss")
                        .format(Date()),
            fontSize = 12.sp,
            color = Color.Black,
            modifier = Modifier.align(
                if (message.isFromLocalUser) Alignment.Start else Alignment.End
            )
        )
        HorizontalDivider(
            thickness = 4.dp,
            color = if (message.isFromLocalUser) OldRose else Plum
        )
        Text(
            text = message.message,
            color = Color.Black,
            modifier = Modifier
                .widthIn(max = 250.dp)
                .padding(top = 2.dp)
        )
    }
}

@Preview
@Composable
fun ChatMessagePreview(){
    ProjektAndroidTheme {
        ChatMessage(
            message = BluetoothMessage(
                message = "Hello world!",
                senderName = "Pixel",
                isFromLocalUser = false
            )
        )
    }
}
