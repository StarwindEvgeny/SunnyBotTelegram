package ru.stnkv.sunnyBotKt.messageCat.diag.dtc

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class D0600 {
    companion object {
         const val CAPTION: String =
            "Ошибка P0600 указывает на наличие неисправности, связанной с каналом связи модуля управления двигателем (ECM).\n" +
                    "\n" +
                    "Возможные причины возникновения ошибки:\n" +
                    "\n" +
                    "<i>- неисправность модуля управления двигателем (ECM);\n" +
                    "- низкое напряжение аккумуляторной батареи;\n" +
                    "- короткое замыкание или обрыв электрических проводов, относящихся к модулю управления двигателем (ECM);\n" +
                    "- ослабление или повреждение разъёма модуля управления двигателем (ECM).</i>"

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