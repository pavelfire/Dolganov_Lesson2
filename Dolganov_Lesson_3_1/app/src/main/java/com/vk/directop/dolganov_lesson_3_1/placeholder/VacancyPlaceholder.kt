package com.vk.directop.dolganov_lesson_3_1.placeholder

import java.util.ArrayList
import java.util.HashMap

object VacancyPlaceholder {

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
                2, "Java Developer", "опыт в роли Java Developer от 4-х лет",
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
                "Android Developer","Kotlin, Coroutines, MVP/MVVM/MVI.",
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
        addItem(
            VacancyItem(
                5,
                "iOS Developer",
                "Разработчик мобильных приложений, Старший (Senior)",
                "Swift/Obj-C, Core Data, Alamofire/Moyo, R.swift, Swinject, SnapKit, PromiseKit, Kingfisher, PureLayout, Firebase",
                "опыт работы в роли iOS Developer от 4-х лет;\n" +
                        "знание Swift и Xcode;\n" +
                        "знание GCD;\n" +
                        "знание CI/CD, опыт его настройки;\n" +
                        "знание ARC, GCD;\n" +
                        "знание UIKit, Core Data;\n" +
                        "понимание архитектурных подходов MVP и MVVM;\n" +
                        "опыт работы с микросервисами;\n" +
                        "опыт проектирования клиент-серверного взаимодействия;\n" +
                        "опыт создания кастомных UI-компонентов.",
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
                6,
                "SRE Engineer",
                "Девопс инженер, Средний (Middle) • Docker • Linux • Kubernetes ",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                7,
                "Full-Stack Developer",
                "Фулстек разработчик, Средний (Middle) • Java • ООП • JavaScript • React",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                8,
                "Android Developer",
                "Разработчик мобильных приложений, Средний (Middle) • Разработка под Android • Разработка мобильных приложений • RxJava 2 • Java • Kotlin • Coroutines • MVVM",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                9,
                "Full-Stack Developer",
                "Фулстек разработчик, Средний (Middle) • TypeScript • React • Java • Kotlin",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                10,
                "DevOps",
                "Девопс инженер, Младший (Junior) • Linux • Docker • CI/CD",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                11,
                "Аналитик 1С",
                "Системный аналитик, Средний (Middle) • Администрирование 1С • Системная аналитика • Бизнес аналитика • Описание бизнес-процессов • UML • Jira • Разработка под 1С",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                12,
                "UI/UX Designer",
                "UI/UX дизайнер, Младший (Junior) • Figma Design • UI/UX дизайн",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                13,
                "UI/UX Designer",
                "UI/UX дизайнер, Средний (Middle) • Figma Design • UI/UX дизайн",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                14,
                "Java Developer",
                "Бэкенд разработчик, Средний (Middle) • Java • Apache Kafka • Kotlin",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                15,
                "Lead Android Developer",
                "Разработчик мобильных приложений, Ведущий (Lead) • Разработка под Android • Kotlin • Java • Android SDK",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                16,
                "Flutter Developer",
                "Разработчик мобильных приложений, Средний (Middle) • Flutter • Dart • Kotlin • Dagger 2",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                17,
                "System Analyst",
                "Системный аналитик, Средний (Middle) • Системная аналитика • Анализ требований • Системный анализ • SQL",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                18,
                "Business Analyst",
                "Бизнес-аналитик, Средний (Middle) • Бизнес аналитика • Microsoft Visio • Бизнес-моделирование • Aris • Описание бизнес-процессов",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                19,
                "Android Developer",
                "Разработчик мобильных приложений, Средний (Middle) • Разработка под Android • Разработка мобильных приложений • Kotlin • Dagger 2 • RxJava 2 • MVVM",
                "",
                "",
                ""
            )
        )
        addItem(
            VacancyItem(
                20,
                "Go Developer",
                "Бэкенд разработчик, Средний (Middle) • Golang • SQL • Gin • Fiber",
                "",
                "",
                ""
            )
        )
    }
}