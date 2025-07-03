package ru.stnkv.SunnyBotKt.MessageCat.Upgrade

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class OtherDop: MakeResponse() {
    override val CAPTION: String = "Раздел самых популярных доработок в разных категориях."

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row3Button2 = InlineKeyboardButton()


        row1Button1.text = "Задние дисковые тормоза";
        row1Button1.url = "https://drive2.ru/l/513956815872983158/";
        row2Button1.text = "Занижение автомобиля";
        row2Button1.url = "https://drive2.ru/l/652834205432026102/";
        row3Button1.text = "⬅️ Назад";
        row3Button1.callbackData = "IMPROVEMENTS_MAIN";
        row3Button2.text = "Главное меню";
        row3Button2.callbackData = "MAIN_MENU_BACK";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1, row3Button2)

        val rows = listOf(row1, row2, row3)

        return InlineKeyboardMarkup(rows)
    }
}