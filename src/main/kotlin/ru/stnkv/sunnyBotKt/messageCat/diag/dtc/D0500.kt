package ru.stnkv.sunnyBotKt.messageCat.diag.dtc

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class D0500 {
    companion object {
         const val CAPTION: String = "Ошибка P0500 – проблема с датчиком скорости. (Дорест, выпущеные до 09.2000)\n" +
                "\n" +
                "Эта ошибка указывает, что электронный блок управления не может запросить информацию с датчика скорости.\n" +
                "\n" +
                "<i>- Датчик скорости вышел из строя.\n" +
                "- Обрыв провода (чаще всего в районе фишки).</i>"

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