package com.vk.directop.dolganov_lesson_3_1

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

const val LOG_TAG = "MY_LOG_TAG"
const val MY_ACTION = "com.vk.directop.dolganov_lesson_3_1.MY_ACTION"

class FibonacciNumberService : Service() {

    private var isStarted = false
    private var counter = 0
    private var number1 = 0
    private var number2 = 0

    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException()
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG, "MyService onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        isStarted = false
        Log.d(LOG_TAG, "MyService onDestroy")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(LOG_TAG, "MyService onStartCommand $intent")

        getSystemService(NotificationManager::class.java)
            .createNotificationChannel(
                NotificationChannel(
                    "aston-channel",
                    "ASTON",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )

        val notification = NotificationCompat.Builder(this, "aston-channel")
            .setContentText("Контент ${counter++}")
            .setContentTitle("Числа Фибоначчи")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()

        startForeground(42, notification)

        if (!isStarted) {
            Thread {
                while (isStarted) {
                    Log.d(LOG_TAG, "MyService ${counter++}")

                    notification.flags = Notification.FLAG_AUTO_CANCEL

                    if (counter == 1000) {
                        stopSelf()
                    }
                    Thread.sleep(1000)
                }
            }.start()
            isStarted = true
        }

        return START_STICKY
    }
}