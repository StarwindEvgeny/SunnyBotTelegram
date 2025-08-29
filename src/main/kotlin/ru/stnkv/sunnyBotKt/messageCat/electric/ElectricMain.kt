package ru.stnkv.sunnyBotKt.messageCat.electric

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class ElectricMain {
    companion object {
        const val CAPTION: String = "<b>Раздел электрики автомобиля.</b>\n" +
                "\n" +
                "<i>✅ Расшифровка основных блоков предохранителей и блоков реле в автомобиле\n" +
                "\n" +
                "✅ Типы ламп, применямые в автомобиле</i>"


        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()

            row1Button1.text = "Предохранители и реле"
            row1Button1.callbackData = "FUSES_INFO"
            row2Button1.text = "Блоки управления двигателем"
            row2Button1.callbackData = "EFI_INFO"
            row3Button1.text = "Лампы"
            row3Button1.callbackData = "LAMPS_INFO"
            row4Button1.text = "Главное меню"
            row4Button1.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1)
            val row2 = listOf(row2Button1)
            val row3 = listOf(row3Button1)
            val row4 = listOf(row4Button1)

            val rows = listOf(row1, row2, row3, row4)

            return InlineKeyboardMarkup(rows)
        }
    }
}