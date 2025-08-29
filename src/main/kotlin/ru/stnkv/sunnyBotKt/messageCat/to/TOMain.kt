package ru.stnkv.sunnyBotKt.messageCat.to

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class TOMain {
    companion object {
        const val CAPTION: String =
            "Раздел с необходимой информацией для проведения технического обслуживания автомобиля.\n" +
                    "\n" +
                    "✅ Двигатель\n" +
                    "\n" +
                    "✅ КПП/АКПП\n" +
                    "\n" +
                    "✅ Топливная системы автомобиля\n" +
                    "\n" +
                    "✅ Система охлаждения автомобиля\n" +
                    "\n" +
                    "✅ Система кондиционирования автомобиля\n" +
                    "\n" +
                    "✅ Тормозная система автомобиля\n" +
                    "\n" +
                    "✅ ГУР и прочее"

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row5Button1 = InlineKeyboardButton()
            val row6Button1 = InlineKeyboardButton()
            val row6Button2 = InlineKeyboardButton()

            row1Button1.text = "Двигатель"
            row1Button1.callbackData = "TO_Engine"
            row1Button2.text = "КПП/АКПП"
            row1Button2.callbackData = "TO_AT"
            row2Button1.text = "Топливная система"
            row2Button1.callbackData = "TO_FUEL_SYSTEM"
            row3Button1.text = "Система охдаждения"
            row3Button1.callbackData = "TO_COOLING_SYSTEM"
            row4Button1.text = "Система кондиционирования"
            row4Button1.callbackData = "TO_CONDITION_SYSTEM"
            row5Button1.text = "Тормозная система"
            row5Button1.callbackData = "TO_BRAKE_SYSTEM"
            row6Button1.text = "Прочее"
            row6Button1.callbackData = "TO_OTHER"
            row6Button2.text = "Главное меню"
            row6Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val row2 = listOf(row2Button1)
            val row3 = listOf(row3Button1)
            val row4 = listOf(row4Button1)
            val row5 = listOf(row5Button1)
            val row6 = listOf(row6Button1, row6Button2)

            val rows = listOf(row1, row2, row3, row4, row5, row6)

            return InlineKeyboardMarkup(rows)
        }
    }
}