package com.example.projektandroid.di

import android.content.Context
import com.example.projektandroid.data.AndroidBluetoothController
import com.example.projektandroid.models.BluetoothController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBluetoothController(@ApplicationContext context: Context): BluetoothController{
        return AndroidBluetoothController(context)
    }
}