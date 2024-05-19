package com.example.projektandroid.data

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.example.projektandroid.models.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain{
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}