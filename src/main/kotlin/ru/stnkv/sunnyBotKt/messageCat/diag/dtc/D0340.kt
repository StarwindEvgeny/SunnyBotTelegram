package ru.stnkv.sunnyBotKt.messageCat.diag.dtc

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class D0340 {
    companion object {
         const val CAPTION: String = "P0340 Неисправность в цепи датчика положения распредвала.\n" +
                "\n" +
                "Основные причины ошибки:\n" +
                "\n" +
                "<i>- Неисправен датчик ДПРВ.\n" +
                "- Неисправность проводки (Чаще всего в районе фишки датчика)\n" +
                "- Признак неправильных фаз ГРМ (Растянутая цепь)</i>"

         fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()

            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "DECODING_ERRORS_INFO"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}