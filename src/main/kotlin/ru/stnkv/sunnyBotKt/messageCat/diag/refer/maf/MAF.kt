package ru.stnkv.sunnyBotKt.messageCat.diag.refer.maf

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class MAF {
    companion object {
         const val IMAGE_DIR: String = "/home/evgeny/docks/Image/MAF.jpg"
         const val CAPTION: String =
            "Процедуру замера рекомендуется проводить на <u>ПОЛНОСТЬЮ</u> прогретом автомобиле <u>БЕЗ ПОТРЕБИТЕЛЕЙ.</u>\n" +
                    "\n" +
                    "\n" +
                    "✅ Рекомендуемые показания <b>ОРИГИНАЛЬНОГО</b> MAF Sensor'a:\n" +
                    "\n" +
                    "<i>- Ключ зажигания в положении ON (Двигатель не запущен) - 1.00V-1.05V\n" +
                    "\n" +
                    "- На оборотах холостого хода - Колебания 1.24V - 1.39V\n" +
                    "\n" +
                    "- На 2000 RPM - Колебания 1.44V - 1.59V</i>\n" +
                    "\n" +
                    "\n" +
                    "✅ Рекомендуемые показания <b>HITACHI</b> MAF Sensor'a:\n" +
                    "\n" +
                    "<i>- Ключ зажигания в положении ON (Двигатель не запущен) ~ 0.345V\n" +
                    "\n" +
                    "- На оборотах холостого хода - Колебания 0.9 - 0.95V\n" +
                    "\n" +
                    "- На 2000 RPM - Колебания в пределах 1.435 - 1.46V\n" +
                    "\n" +
                    "- Часовой расход воздуха БЕЗ ПОТРЕБИТЕЛЕЙ 0.6 - 0.75</i>"

         fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()


            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "BACK_TO_REFERENCES"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}