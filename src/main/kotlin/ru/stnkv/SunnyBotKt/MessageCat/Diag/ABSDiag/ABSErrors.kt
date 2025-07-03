package ru.stnkv.SunnyBotKt.MessageCat.Diag.ABSDiag

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class ABSErrors: MakeResponse() {
    override val CAPTION: String = ""
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/ABSERRORS.jpg"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()

        row1Button1.text = "⬅️ Назад"
        row1Button1.callbackData = "ABS_DIAGNOSTICS_INFO"
        row1Button2.text = "Главное меню"
        row1Button2.callbackData = "MAIN_MENU"

        val row1 = listOf(row1Button1, row1Button2)
        val rows = listOf(row1)

        return InlineKeyboardMarkup(rows)
    }
}