package ru.stnkv.sunnyBotKt.messageCat.upgrade

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class ElectricDop {
    companion object {
        const val CAPTION: String = "Раздел самых популярных доработок в категории Электрика."

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row5Button1 = InlineKeyboardButton()
            val row6Button1 = InlineKeyboardButton()
            val row6Button2 = InlineKeyboardButton()

            row1Button1.text = "Выбор комбинации приборов"
            row1Button1.url = "https://drive2.ru/l/641999892729840432/"
            row2Button1.text = "Оптитрон Дорестайлинг"
            row2Button1.url = "https://drive2.ru/l/562376559181169765/"
            row3Button1.text = "Комбинация приборов Рестайлинг"
            row3Button1.url = "https://drive2.ru/l/629944022609178538/"
            row4Button1.text = "Электронный климат"
            row4Button1.url = "https://www.drive2.ru/l/2847620/"
            row5Button1.text = "Режимы Snow/Sport АКПП"
            row5Button1.url = "https://drive2.ru/l/669449200517259554/"
            row6Button1.text = "⬅️ Назад"
            row6Button1.callbackData = "IMPROVEMENTS_MAIN"
            row6Button2.text = "Главное меню"
            row6Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1)
            val row2 = listOf(row2Button1)
            val row3 = listOf(row3Button1)
            val row4 = listOf(row4Button1)
            val row5 = listOf(row5Button1)
            val row6 = listOf(row6Button1, row6Button2)

            val rows = listOf(row1, row2, row3, row4, row5, row6)

            return InlineKeyboardMarkup(rows)
        }
    }
}