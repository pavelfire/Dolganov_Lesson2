package com.vk.directop.dolganov_lesson_3_1.placeholder

import java.util.ArrayList
import java.util.HashMap

object OfficePlaceholder {

    val ITEMS: MutableList<OfficeItem> = ArrayList()

    val ITEM_MAP: MutableMap<Int, OfficeItem> = HashMap()

    private fun addItem(item: OfficeItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    data class OfficeItem(
        val id: Int,
        val city: String,
        val address: String,
        val viewType: Int = 2,
    ) {
        override fun toString(): String {
            return super.toString()
        }
    }

    init {
        addItem(
            OfficeItem(
                1,
                "Москва",
                "Пресненская набережная, д.6, стр.2, БЦ \"Башня Империя\", 3 подъезд, 53 этаж, офис 13, Россия",
                1
            )
        )
        addItem(
            OfficeItem(
                2, "Санкт-Петербург",
                "Владимирский проспект 23, БЦ \"Ренессанс Холл\" 8 этаж, 801, Россия",
                1
            )
        )
        addItem(
            OfficeItem(
                3, "Казань",
                "ул. Н. Ершова, 76/1, оф. 213, Россия",
                1
            )
        )
        addItem(
            OfficeItem(
                4,
                "Ростов-на-Дону",
                "ул. Текучева, 246, 3 этаж, Россия",
                1
            )
        )
        addItem(
            OfficeItem(
                5,
                "Алматы",
                "Бостандыкский район, микрорайон Коктем-2, здание 22, Казахстан",
                3
            )
        )
        addItem(
            OfficeItem(
                6,
                "Минск",
                "пр-т Победителей, 7А, Беларусь",
                2
            )
        )
        addItem(
            OfficeItem(
                7,
                "Полоцк",
                "ул. Октябрьская, 25, Беларусь",
                2
            )
        )
        addItem(
            OfficeItem(
                8,
                "Витебск",
                "ул. Строителей, 11А\n" +
                        "\n" +
                        "Московский проспект, 70, корп. 1, Беларусь",
                2
            )
        )
        addItem(
            OfficeItem(
                9,
                "Гомель",
                "ул. Советская, 41Б, Беларусь",
                2
            )
        )
    }
}