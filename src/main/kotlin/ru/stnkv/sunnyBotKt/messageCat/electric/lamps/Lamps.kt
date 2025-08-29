package ru.stnkv.sunnyBotKt.messageCat.electric.lamps

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class Lamps {
    companion object {
        const val CAPTION: String = "Лампы освещения, применяемые в автомобиле\n" +
                "\n" +
                "\n" +
                "✅ Головной свет - IH01\n" +
                "\n" +
                "✅ Габаритные огни впереди - w5w -5Вт\n" +
                "\n" +
                "✅ Указатели поворота спереди - 21W - 21вт\n" +
                "\n" +
                "✅ Противотуманные огни\n" +
                "- Рестайлинг - H11\n" +
                "- Дорестайлинг H3\n" +
                "\n" +
                "✅ Задний стоп-сигнал/габарит - w21/5вт\n" +
                "\n" +
                "✅ Указатели поворота сзади - w21w\n" +
                "\n" +
                "✅ Фонарь заднего хода - w16w\n" +
                "\n" +
                "✅ Номерной знак w5w 5Вт\n" +
                "\n" +
                "✅ Стоп сигнал в салоне - w18w - 18Вт\n" +
                "\n" +
                "✅ Освещение багажного отсека - w3.4w 3.4Вт\n" +
                "\n" +
                "✅ Плафон освещения салона. с10w 7Вт\n" +
                "\n" +
                "✅ Климатическая установка - T3 - 1.2Вт\n" +
                "\n" +
                "✅ Комбинация приборов - T5 w1.2w или T6.5\n" +
                "\n" +
                "✅ Подсветка пепельницы - t3 - 3Вт\n" +
                "\n" +
                "✅ Селектор АКПП - w5w"


        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()

            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "ELECTRIC_MAIN"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}