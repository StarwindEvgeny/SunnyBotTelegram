package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class D0115: MakeResponse() {
    override val CAPTION: String = "Ошибка P0115 указывает на неисправность электрической цепи датчика температуры охлаждающей жидкости.\n" +
            "\n" +
            "Модуль управления двигателем (ECM) обнаружил слишком низкое или слишком высокое напряжение в цепи датчика температуры охлаждающей жидкости. Это означает, что напряжение находится вне заданного диапазона, который составляет 0,14–4,91 В.\n" +
            "\n" +
            "Возможные причины возникновения ошибки P0115:\n" +
            "\n" +
            "<i>-Обрыв в жгуте проводов.\n" +
            "-Неисправность датчика.\n" +
            "-Коррозия электрического разъёма датчика температуры охлаждающей жидкости.</i>"


    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()

        row1Button1.text = "⬅️ Назад";
        row1Button1.callbackData = "DECODING_ERRORS_INFO";
        row1Button2.text = "Главное меню";
        row1Button2.callbackData = "MAIN_MENU_BACK";

        val row1 = listOf(row1Button1, row1Button2)
        val rows = listOf(row1)

        return InlineKeyboardMarkup(rows)
    }
}