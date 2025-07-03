package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class D0400: MakeResponse() {
    override val CAPTION: String = "Ошибка P0400 в автомобиле Nissan означает неисправность потока рециркуляции отработавших газов (неисправность контроля системы улавливания паров бензина).\n" +
            "\n" +
            "Возможные причины:\n" +
            "\n" +
            "<i>- Клапан EGR не открывается — не работает электромагнит клапана.\n" +
            "- Каналы клапана EGR не герметичны.\n" +
            "- Датчик температуры EGR не регистрирует изменение температуры при открытии клапана EGR.\n" +
            "- Каналы EGR забиты и не позволяют потоку выхлопных газов поступать во впускной коллектор.\n" +
            "- Стоит заглушка.</i>"

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