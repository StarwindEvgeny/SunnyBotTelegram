package ru.stnkv.sunnyBotKt.messageCat.electric.fuses

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class DorestInside {
    companion object {
        const val IMAGE_DIR: String = "/home/evgeny/docks/Image/DorestInside.png"

        const val CAPTION: String = ""

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()


            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "FUSES_INFO_BACK"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}