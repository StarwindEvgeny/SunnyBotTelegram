package ru.stnkv.sunnyBotKt.messageCat.aboutProject

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class About {
    companion object {
         const val CAPTION: String = "О проекте.\n" +
                "\n" +
                "✅ Все функции и материалы бота <b>предоставлются БЕСПЛАТНО, БЕЗ УСЛОВИЙ</b>, а так же <b>БЕЗ ОГРАНИЧЕНИЙ ДЛЯ ВСЕХ.</b>\n" +
                "\n" +
                "✅ Вы можете добавить бота в свой чат в качестве участника. У чата появится меню вызова, любой участник сможет пользоваться ботом прямо внутри чата." +
                "\n\n" +
                "✅ Связаться со мной и предложить <i>материалы, статью, важные на ваш взгляд дополнения к существующим разделам, или указав на ошибки в данных</i>\n\n" +
                "✅ Ознакомиться со списком ключевых слов, для быстрого перехода."


        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()


            row1Button1.text = "Связаться с разработчиком \uD83D\uDCDD"
            row1Button1.url = "https://t.me/EVGSTNKV"
            row2Button1.text = "Список ключевых слов"
            row2Button1.callbackData = "KEY_WORDS"
            row3Button1.text = "Главное меню"
            row3Button1.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1)
            val row2 = listOf(row2Button1)
            val row3 = listOf(row3Button1)

            val rows = listOf(row1, row2, row3)

            return InlineKeyboardMarkup(rows)
        }
    }
}