package com.vk.directop.dolganov_lesson_3_1.placeholder

import java.util.ArrayList
import java.util.HashMap

object PlaceholderContent {

    val ITEMS: MutableList<VacancyItem> = ArrayList()

    val ITEM_MAP: MutableMap<Int, VacancyItem> = HashMap()

    private fun addItem(item: VacancyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    data class VacancyItem(
        val id: Int,
        val title: String,
        val subtitle: String,
        val whatToDo: String,
        val requirements: String,
        val socialPack: String
    ) {
        override fun toString(): String {
            return super.toString()
        }
    }

    init {
        addItem(
            VacancyItem(
                1,
                "Android Trainee", "Стажировка по направлению Android",
                "Выполнять задачи в команде",
                "Прохождение курсов, крепкие зная Java и Kotlin, наличие своих приложений как плюс.",
                "Стажировка может быть как оплачиваемая, так и не оплачиваемая."
            )
        )
        addItem(
            VacancyItem(
                2, "Java Developer", "опыт работы в роли Java Developer от 4-х лет",
                "разрабатывать приложения, которые масштабируются на все дистанционные каналы банка: интернет-банк, мобильные приложения, платёжные сервисы и др.;\n" +
                        "коммуницировать с командами разработки, Data Science, поддержки и другими;\n" +
                        "создавать Fintech-решения с применением современного технологического стека;\n" +
                        "развивать архитектуру, предлагать новые идеи и оценивать старые.",
                "опыт работы в роли Java Developer от 4-х лет;\n" +
                        "опыт работы с Java 8+, Kotlin, Spring, Spring Boot;\n" +
                        "опыт работы с системами на микросервисной архитектуре (Spring Cloud, Kubernetes, OpenShift или аналоги);\n" +
                        "опыт работы с Docker;\n" +
                        "опыт работы с 3-мя любыми из технологий NoSQL и SQL: MongoDB, Elasticsearch, PostgreSQL, Oracle и аналоги;\n" +
                        "опыт работы с брокерами сообщений (Kafka, RabbitMQ, аналоги)\n" +
                        "знание Reactive Programming (RxJava, Project Reactor), Cache (Redis, Hazelcast);\n" +
                        "опыт настройки CI/CD (GitLab CI, Jenkins, аналоги);\n" +
                        "опыт настройки средств мониторинга (Zabbix, Prometheus) и средств логирования (Graylog, ELK);\n" +
                        "хорошие коммуникативные навыки или желание их развивать.",
                "медицинская страховка (+стоматология);\n" +
                        "частичная компенсация спортивных абонементов;\n" +
                        "компенсация расходов на оплату коворкинга;\n" +
                        "3 sick-days в год;\n" +
                        "оплачиваемый бенч;\n" +
                        "оплачиваемый отпуск 28 дней в году;\n" +
                        "оплачиваемые больничные."
            )
        )
        addItem(
            VacancyItem(
                3, "Python Developer", "Требуемый опыт работы: 3–6 лет",
                "",
                "опыт коммерческой разработки на Python от 6-ти лет;\n" +
                        "владение одним из фреймворков: AIOHTTP, Sanic, FastAPI, Starlette, Django, Flask;\n" +
                        "умение писать SQL-запросы без использования ORM;\n" +
                        "знание Linux на уровне пользователя.",
                "медицинская страховка (+стоматология);\n" +
                        "частичная компенсация спортивных абонементов;\n" +
                        "компенсация расходов на оплату коворкинга;\n" +
                        "3 sick-days в год;\n" +
                        "оплачиваемый бенч;\n" +
                        "оплачиваемый отпуск 28 дней в году;\n" +
                        "оплачиваемые больничные."
            )
        )
        addItem(
            VacancyItem(
                4,
                "Android Developer",
                "Технологический стек на проекте: Java/Kotlin, RxJava/Coroutines, MVP/MVVM/MVI.",
                "",
                "опыт коммерческой разработки под Android от 3-х лет;\n" +
                        "хорошие знания и понимание принципов работы компонентов Android;\n" +
                        "знание Kotlin;\n" +
                        "знание и понимание работы библиотек RxJava 2 или Coroutines, Retrofit, Room;\n" +
                        "знание ООП, подходов Clean Architecture, принципов SOLID, шаблонов проектирования MVVM, MVI и MVP;\n" +
                        "понимание принципов DI, знание одного из DI-фреймворков (Dagger 2, Hilt).",
                "медицинская страховка (+стоматология);\n" +
                        "частичная компенсация спортивных абонементов;\n" +
                        "компенсация расходов на оплату коворкинга;\n" +
                        "3 sick-days в год;\n" +
                        "оплачиваемый бенч;\n" +
                        "оплачиваемый отпуск 28 дней в году;\n" +
                        "оплачиваемые больничные."
            )
        )
    }
}