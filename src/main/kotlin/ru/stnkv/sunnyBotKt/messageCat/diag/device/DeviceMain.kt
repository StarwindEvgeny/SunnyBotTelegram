package ru.stnkv.sunnyBotKt.messageCat.diag.device

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class DeviceMain {
    companion object {
        const val CAPTION: String = "Основныe устройства для считывания ошибок и показаний автомобиля:\n" +
                "\n" +
                "✅ ELM-327\n" +
                "✅ Кабель NISSAN3LINE\n" +
                "✅ Кабель VAG COM KKL 409.1\n" +
                "✅ Ручной способ диагностики\n" +
                "\n" +
                " Что бы узнать подробнее выберите устройство\uD83D\uDC47"

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row5Button1 = InlineKeyboardButton()
            val row5Button2 = InlineKeyboardButton()


            row1Button1.text = "ELM-327"
            row1Button1.callbackData = "ELM327_INFO"
            row2Button1.text = "Кабель NISSAN3LINE"
            row2Button1.callbackData = "NISSAN3LINE_INFO"
            row3Button1.text = "Кабель VAG COM KKL 409.1"
            row3Button1.callbackData = "VAGCOMKKL_INFO"
            row4Button1.text = "Ручной способ чтения ошибок"
            row4Button1.callbackData = "MANUAL_DIAGNOSTIC_INFO"
            row5Button1.text = "⬅️ Назад"
            row5Button1.callbackData = "COMPUTER_DIAGNOSTIC_MAIN"
            row5Button2.text = "Главное меню"
            row5Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1)
            val row2 = listOf(row2Button1)
            val row3 = listOf(row3Button1)
            val row4 = listOf(row4Button1)
            val row5 = listOf(row5Button1, row5Button2)

            val rows = listOf(row1, row2, row3, row4, row5)

            return InlineKeyboardMarkup(rows)
        }
    }
}