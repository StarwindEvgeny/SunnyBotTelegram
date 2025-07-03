package ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class FusesInfo: MakeResponse() {
    override val CAPTION: String = "Расшифровка блоков предохранителей и реле."

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()
        val row5Button1 = InlineKeyboardButton()
        val row6Button1 = InlineKeyboardButton()
        val row7Button1 = InlineKeyboardButton()
        val row7Button2 = InlineKeyboardButton()

        row1Button1.text = "Дорестайлинг салон"
        row1Button1.callbackData = "DOREST_FUSES_BLOCK_SALOON"
        row2Button1.text = "Дорестайлинг снаружи"
        row2Button1.callbackData = "DOREST_FUSES_BLOCK_OUTSIDE"
        row3Button1.text = "Дорестайлинг блок реле"
        row3Button1.callbackData = "DOREST_OUTSIDE_2"
        row4Button1.text = "Рестайлинг салон"
        row4Button1.callbackData = "REST_FUSES_BLOCK_SALOON"
        row5Button1.text = "Рестайлинг снаружи"
        row5Button1.callbackData = "REST_FUSES_BLOCK_OUTSIDE"
        row6Button1.text = "Рестайлинг блок реле"
        row6Button1.callbackData = "REST_OUTSIDE_2"
        row7Button1.text = "Назад"
        row7Button1.callbackData = "ELECTRIC_MAIN"
        row7Button2.text = "Главное меню"
        row7Button2.callbackData = "MAIN_MENU_BACK"

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1)
        val row4 = listOf(row4Button1)
        val row5 = listOf(row5Button1)
        val row6 = listOf(row6Button1)
        val row7 = listOf(row7Button1, row7Button2)

        val rows = listOf(row1, row2, row3, row4, row5, row6, row7)

        return InlineKeyboardMarkup(rows)
    }
}