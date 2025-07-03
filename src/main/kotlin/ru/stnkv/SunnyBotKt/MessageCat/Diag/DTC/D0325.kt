package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class D0325: MakeResponse() {
    override val CAPTION: String = "Ошибка P0325 относится к датчику детонации на блоке 1 двигателя. Она означает, что датчик не посылает правильные сигналы на контроллер. Это может происходить по разным причинам: от плохой проводки до неисправного датчика.\n" +
            "\n" +
            "Причины ошибки P0325:\n" +
            "\n" +
            "<i>— Неисправный датчик детонации;\n" +
            "— Замыкание в цепи датчика детонации;\n" +
            "— Слабые электрические соединения;\n" +
            "— Некачественное топливо;\n" +
            "— Двигатель работает на бедной смеси;\n" +
            "— Сбой ЭБУ (редко).</i>"

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