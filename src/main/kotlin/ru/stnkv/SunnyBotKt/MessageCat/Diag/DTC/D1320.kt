package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class D1320: MakeResponse() {
    override val CAPTION: String = "P1320 — это код неисправности системы зажигания.\n" +
            "\n" +
            "Возможные причины:\n" +
            "\n" +
            "<i>- Выход или частичный выход из строя катушки зажигания.\n" +
            "- Повреждение проводки катушек зажигания (чаще всего в районе фишки).\n" +
            "- Не оригинальная катушка зажигания зачастую вызывает ошибку бессимптомно.</i>"

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