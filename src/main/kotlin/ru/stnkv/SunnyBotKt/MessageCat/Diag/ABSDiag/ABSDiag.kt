package ru.stnkv.SunnyBotKt.MessageCat.Diag.ABSDiag

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class ABSDiag: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/ABSDiagnostic.jpg"
    override val CAPTION: String = "<i>Процедура диагностики неисправностей антиблокировочной системы без специального оборудования.</i>"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row2Button2 = InlineKeyboardButton()

        row1Button1.text = "Таблица кодов ABS"
        row1Button1.callbackData = "ABS_ERRORS"
        row2Button1.text = "⬅️ Назад"
        row2Button1.callbackData = "COMPUTER_DIAGNOSTICS_BACK"
        row2Button2.text = "Главное меню"
        row2Button2.callbackData = "MAIN_MENU"

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1, row2Button2)

        val rows = listOf(row1, row2)

        return InlineKeyboardMarkup(rows)
    }
}