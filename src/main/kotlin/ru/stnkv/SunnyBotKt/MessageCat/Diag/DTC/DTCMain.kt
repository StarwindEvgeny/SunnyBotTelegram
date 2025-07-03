package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class DTCMain: MakeResponse() {
    override val CAPTION: String = "✅ Раздел с основными DTC двигателя.\n" +
            "\n" +
            "Что бы узнать расшифровку и основные причины выберите код \uD83D\uDC47"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()
        val row1Button3 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row2Button2 = InlineKeyboardButton()
        val row2Button3 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row3Button2 = InlineKeyboardButton()
        val row3Button3 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()
        val row4Button2 = InlineKeyboardButton()
        val row4Button3 = InlineKeyboardButton()
        val row5Button1 = InlineKeyboardButton()
        val row5Button2 = InlineKeyboardButton()

        row1Button1.text = "P0100";
        row1Button1.callbackData = "P0100_INFO";
        row1Button2.text = "P0113";
        row1Button2.callbackData = "P0113_INFO";
        row1Button3.text = "P0115";
        row1Button3.callbackData = "P0115_INFO";

        row2Button1.text = "P0130";
        row2Button1.callbackData = "P0130_INFO";
        row2Button2.text = "P0325";
        row2Button2.callbackData = "P0325_INFO";
        row2Button3.text = "P0335";
        row2Button3.callbackData = "P0335_INFO";

        row3Button1.text = "P0340";
        row3Button1.callbackData = "P0340_INFO";
        row3Button2.text = "P0400";
        row3Button2.callbackData = "P0400_INFO";
        row3Button3.text = "P0500";
        row3Button3.callbackData = "P0500_INFO";

        row4Button1.text = "P0600";
        row4Button1.callbackData = "P0600_INFO";
        row4Button2.text = "P1217";
        row4Button2.callbackData = "P1217_INFO";
        row4Button3.text = "P1320";
        row4Button3.callbackData = "P1320_INFO";

        row5Button1.text = "⬅️ Назад";
        row5Button1.callbackData = "COMPUTER_DIAGNOSTIC_MAIN";
        row5Button2.text = "Главное меню";
        row5Button2.callbackData = "MAIN_MENU_BACK";

        val row1 = listOf(row1Button1, row1Button2, row1Button3)
        val row2 = listOf(row2Button1, row2Button2, row2Button3)
        val row3 = listOf(row3Button1, row3Button2, row3Button3)
        val row4 = listOf(row4Button1, row4Button2, row4Button3)
        val row5 = listOf(row5Button1, row5Button2)

        val rows = listOf(row1, row2, row3, row4, row5)

        return InlineKeyboardMarkup(rows)
    }
}