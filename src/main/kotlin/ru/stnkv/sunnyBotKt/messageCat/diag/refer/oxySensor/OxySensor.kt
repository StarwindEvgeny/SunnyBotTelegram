package ru.stnkv.sunnyBotKt.messageCat.diag.refer.oxySensor

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class OxySensor {
    companion object {
        const val IMAGE_DIR: String = "/home/evgeny/docks/Image/OxygenSensor.jpg"
        const val CAPTION: String =
            "Процедуру замера рекомендуется проводить на <u>ПОЛНОСТЬЮ</u> прогретом автомобиле <u>БЕЗ ПОТРЕБИТЕЛЕЙ.</u>\n" +
                    "\n" +
                    "\n" +
                    "<b>Обратите внимание!</b>\n" +
                    "\n" +
                    "- Датчик кислорода начинает работать правильно при нагреве до 600C.\n" +
                    "\n" +
                    "- Для точного результата удерживайте 2000-2500RPM в течении 10-20 секунд для нагревания датчика.\n" +
                    "\n" +
                    "- Проводите измерения удерживая 2000-2500RPM.\n" +
                    "\n" +
                    "\n" +
                    "<b>Нормальные показания датчика кислорода</b>\n" +
                    "\n" +
                    "<i>- Постоянное переключение от 0.1V до 0.8V согласно графику выше.\n" +
                    "\n" +
                    "- Чем чаще переключения - тем лучше.\n" +
                    "\n" +
                    "- Обратите вниманиe на момент переключения. Он должен быть моментальным без задержки, амплитудные значения на графике образуют острые пиковые значения (обведено красным).</i>"


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