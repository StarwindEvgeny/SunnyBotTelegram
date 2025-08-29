package ru.stnkv.sunnyBotKt.messageCat.diag.refer

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class ReferMain {
    companion object {
        const val CAPTION: String = "✅ В разделе собраны референсные показания основных датчиков автомобиля.\n" +
                "\n" +
                "Что бы узнать подробнее выберите датчик \uD83D\uDC47"

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row4Button2 = InlineKeyboardButton()

            row1Button1.text = "MAF Sensor"
            row1Button1.callbackData = "MAF_SENSOR_REFERENCE"
            row2Button1.text = "Датчик кислорода"
            row2Button1.callbackData = "CO_SENSOR_REFERENCE"
            row3Button1.text = "Прочие параметры"
            row3Button1.callbackData = "OTHER_REFERENCE"
            row4Button1.text = "⬅️ Назад"
            row4Button1.callbackData = "COMPUTER_DIAGNOSTIC_MAIN"
            row4Button2.text = "Главное меню"
            row4Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1)
            val row2 = listOf(row2Button1)
            val row3 = listOf(row3Button1)
            val row4 = listOf(row4Button1, row4Button2)

            val rows = listOf(row1, row2, row3, row4)

            return InlineKeyboardMarkup(rows)
        }
    }
}