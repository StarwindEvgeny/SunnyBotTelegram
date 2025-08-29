package ru.stnkv.sunnyBotKt.messageCat.diag.programs

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class ProgramsMain {
    companion object {
         const val CAPTION: String =
            "Чаще всего для диагностики с помощью мобильных устройств используют такие программы как:\n" +
                    "\n" +
                    "✅ CarScanner\n" +
                    "\n" +
                    "✅ Nissan EconTool\n" +
                    "\n" +
                    "Для ПК и ноутбука используют\n" +
                    "\n" +
                    "✅ TECU3\n" +
                    "\n" +
                    "Что бы скачать и узнать как подключиться выберите программу \uD83D\uDC47"


         fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row4Button2 = InlineKeyboardButton()


            row1Button1.text = "CarScanner"
            row1Button1.callbackData = "CAR_SCANNER_INFO"
            row2Button1.text = "NISSAN EconTool"
            row2Button1.callbackData = "NISSAN_ECONTOOL_INFO"
            row3Button1.text = "TECU3"
            row3Button1.callbackData = "TECU3_INFO"
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