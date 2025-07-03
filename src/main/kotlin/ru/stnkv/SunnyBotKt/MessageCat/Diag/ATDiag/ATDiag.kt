package ru.stnkv.SunnyBotKt.MessageCat.Diag.ATDiag

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class ATDiag: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/ATDiagnostic.jpg"
    override val CAPTION: String = "\n" +
            "Процедура самодиагностики АКПП без специального оборудования, а так же коды ошибок."

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()

        row1Button1.text = "⬅️ Назад"
        row1Button1.callbackData = "COMPUTER_DIAGNOSTICS_BACK"
        row1Button2.text = "Главное меню"
        row1Button2.callbackData = "MAIN_MENU"

        val row1 = listOf(row1Button1, row1Button2)
        val rows = listOf(row1)

        return InlineKeyboardMarkup(rows)
    }
}