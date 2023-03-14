package com.vk.directop.dolganov_lesson_3_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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