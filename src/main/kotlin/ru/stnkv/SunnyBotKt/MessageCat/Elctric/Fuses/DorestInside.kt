package ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class DorestInside: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/DorestInside.png"

    override val CAPTION: String = ""

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()


        row1Button1.text = "⬅️ Назад";
        row1Button1.callbackData = "FUSES_INFO_BACK";
        row1Button2.text = "Главное меню";
        row1Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1, row1Button2)
        val rows = listOf(row1)

        return InlineKeyboardMarkup(rows)
    }
}