package com.vk.directop.dolganov_lesson_3_1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.vk.directop.dolganov_lesson_3_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val receiver = FibonacciNumberBroadcastReceiver()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(LOG_TAG, "Activity onCreate")

        binding.startServiceButton.setOnClickListener {
            Log.d(LOG_TAG, "Start pressed")
            startForegroundService(Intent(this, FibonacciNumberService::class.java))
            Log.d(LOG_TAG, "Start pressed 2")
        }

        binding.stopServiceButton.setOnClickListener {
            startService(Intent(this, FibonacciNumberService::class.java))
        }

        binding.stopServiceButton.setOnClickListener {
            sendBroadcast(Intent(this, FibonacciNumberBroadcastReceiver::class.java)
                .apply {
                putExtra(BROADCAST_MESSAGE_KEY, "ресивер запущен")
            })

            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(
                Intent(MY_ACTION).apply {
                    putExtra(BROADCAST_MESSAGE_KEY, "ресивер запущен")
                }
            )
        }

    }
}

/*
Практическое задание по сервисам (по желанию, кто хочет попробовать поработать с сервисами):
Создать сервис, который будет каждую секунду выдавать число из последовательности Фибоначчи.
В развернутом активити число должно отображаться на экране. При закрытом активити должно
отображаться уведомление, в которое должно приходить очередное число.

Дополнительно: передачу данных из сервиса в активити в этом задании организовать
через BroadcastReceiver
 */