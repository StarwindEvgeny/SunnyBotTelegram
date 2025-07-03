package ru.stnkv.SunnyBotKt.MessageCat.Upgrade

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class SalonDop: MakeResponse() {
    override val CAPTION: String = "Раздел самых популярных доработок в категории Салон."

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()
        val row5Button1 = InlineKeyboardButton()
        val row5Button2 = InlineKeyboardButton()


        row1Button1.text = "Высокий подлокотник";
        row1Button1.url = "https://www.drive2.ru/l/675776065301399942/";
        row2Button1.text = "Задние воздуховоды";
        row2Button1.url = "https://www.drive2.ru/l/646179136427004862/";
        row3Button1.text = "Руль косточка";
        row3Button1.url = "https://drive2.ru/l/659806758419571080/";
        row4Button1.text = "Интервал на дворниках";
        row4Button1.url = "https://www.drive2.ru/l/3598626/";
        row5Button1.text = "⬅️ Назад";
        row5Button1.callbackData = "IMPROVEMENTS_MAIN";
        row5Button2.text = "Главное меню";
        row5Button2.callbackData = "MAIN_MENU_BACK";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1)
        val row4 = listOf(row4Button1)
        val row5 = listOf(row5Button1, row5Button2)

        val rows = listOf(row1, row2, row3, row4, row5)

        return InlineKeyboardMarkup(rows)
    }
}