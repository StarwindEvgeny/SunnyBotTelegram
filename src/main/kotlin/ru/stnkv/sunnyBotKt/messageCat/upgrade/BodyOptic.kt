package ru.stnkv.sunnyBotKt.messageCat.upgrade

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class BodyOptic {
    companion object {
        const val CAPTION: String = "Раздел самых популярных доработок в категории Кузов/Оптика"

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row5Button1 = InlineKeyboardButton()
            val row6Button1 = InlineKeyboardButton()
            val row6Button2 = InlineKeyboardButton()

            row1Button1.text = "Мини линзы в головной свет"
            row1Button1.url = "https://drive2.ru/l/661242720605443512/"
            row2Button1.text = "Штатные ПТФ"
            row2Button1.url = "https://drive2.ru/l/463626671111537392/"
            row3Button1.text = "Багажник на крышу"
            row3Button1.url = "https://drive2.ru/l/494411622299730247/"
            row4Button1.text = "Светлячки на крылья"
            row4Button1.url = "https://drive2.ru/l/675961607888572309/"
            row5Button1.text = "Передняя решетка"
            row5Button1.url = "https://drive2.ru/l/4062246863888231296/"
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