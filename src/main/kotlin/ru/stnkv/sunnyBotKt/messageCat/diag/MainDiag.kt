package ru.stnkv.sunnyBotKt.messageCat.diag

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class MainDiag {
    companion object {
        const val CAPTION: String = "Раздел компьютерной диагностики автомобиля\n" +
                "\n" +
                "✅ Информация об устройствах чтения кодов неисправностей/показаний датчиков автомобиля.\n" +
                "\n" +
                "✅ Информация о программах для чтения автомобиля для ПК или мобильных устройств.\n" +
                "\n" +
                "✅ Расшифровка основных кодов неисправностей автомобиля.\n" +
                "\n" +
                "✅ Референсные значения показаний датчиков.\n" +
                "\n" +
                "✅ Информация о способах диагностики АКПП, ABS, SRS автомобиля."

        fun getMenu(): InlineKeyboardMarkup {

            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row2Button2 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row3Button2 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row4Button2 = InlineKeyboardButton()

            row1Button1.text = "Устройства"
            row1Button1.callbackData = "DIAGNOSTIC_DEVICES_INFO"
            row1Button2.text = "Программы"
            row1Button2.callbackData = "DIAGNOSTICS_PROGRAMS_INFO"
            row2Button1.text = "Ошибки DTC"
            row2Button1.callbackData = "DECODING_ERRORS_INFO"
            row2Button2.text = "Референсы"
            row2Button2.callbackData = "REFERENCES_INFO"
            row3Button1.text = "АКПП"
            row3Button1.callbackData = "AT_DIAGNOSTICS_INFO"
            row3Button2.text = "Блок ABS"
            row3Button2.callbackData = "ABS_DIAGNOSTICS_INFO"
            row4Button1.text = "SRS"
            row4Button1.callbackData = "SRS_INFO"
            row4Button2.text = "Главное меню"
            row4Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val row2 = listOf(row2Button1, row2Button2)
            val row3 = listOf(row3Button1, row3Button2)
            val row4 = listOf(row4Button1, row4Button2)

            val rows = listOf(row1, row2, row3, row4)

            return InlineKeyboardMarkup(rows)
        }
    }
}