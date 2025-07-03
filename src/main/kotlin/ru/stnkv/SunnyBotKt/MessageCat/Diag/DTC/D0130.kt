package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class D0130: MakeResponse() {
    override val CAPTION: String = "Ошибка P0130 на Nissan Sunny указывает на проблемы, связанные с напряжением в цепи кислородного датчика.\n" +
            "\n" +
            "Возможные причины возникновения ошибки:\n" +
            "\n" +
            "<i>- неисправность разъёмов лямбда-зонда;\n" +
            "- повреждения проводки;\n" +
            "- разгерметизация выпускного коллектора;</i>"

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