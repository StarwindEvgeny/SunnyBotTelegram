package ru.stnkv.sunnyBotKt.messageCat.to.conditioner

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class Conditioner {
    companion object {
        const val CAPTION: String = "Расходные материалы для технического обслуживания системы кондиционирования.\n" +
                "\n" +
                "\n" +
                "✅ <b>Хладагент</b>\n" +
                "\n" +
                "- Заправочный обьем - 500 гр.\n" +
                "- Тип хладагента - R134a.\n" +
                "\n" +
                "✅ <b>Фильтр салонный</b>\n" +
                "\n" +
                "- Номер запчасти - AY684-NS001."

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row2Button2 = InlineKeyboardButton()

            row1Button1.text = "Хладагент"
            row1Button1.url = "https://yandex.ru/search/?text=R134a&lr=11314&clid=2360950&win=650"
            row1Button2.text = "Фильтр салона"
            row1Button2.url = "https://yandex.ru/search/?text=AY684-NS001&lr=11314&clid=2360950&win=650"
            row2Button1.text = "⬅️ Назад"
            row2Button1.callbackData = "TO_MAIN"
            row2Button2.text = "Главное меню"
            row2Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val row2 = listOf(row2Button1, row2Button2)

            val rows = listOf(row1, row2)

            return InlineKeyboardMarkup(rows)
        }
    }
}