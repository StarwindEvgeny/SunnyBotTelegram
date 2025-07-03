package ru.stnkv.SunnyBotKt.MessageCat.Upgrade

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class UpgradeMain: MakeResponse() {
    override val CAPTION: String = "Раздел посвещенный доработкам и дооснащениям автомобиля.\n" +
            "\n" +
            "✅ Прямые ссылки на статьи из открытых источников.\n" +
            "\n" +
            "✅ Чтение статей не выходя из телеграмм!\n" +
            "\n" +
            "✅ Самые популярные доработки!\n" +
            "\n" +
            "Для продолжения выберите нужную категорию."

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row2Button2 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()


        row1Button1.text = "Кузов/Оптика"
        row1Button1.callbackData = "BODY_OPTIC_DOP"
        row1Button2.text = "Электрика"
        row1Button2.callbackData = "ELECTRIC_DOP"
        row2Button1.text = "Салон"
        row2Button1.callbackData = "SALOON_DOP"
        row2Button2.text = "Разное"
        row2Button2.callbackData = "OTHER_DOP"
        row3Button1.text = "Главное меню"
        row3Button1.callbackData = "MAIN_MENU_BACK"

        val row1 = listOf(row1Button1, row1Button2)
        val row2 = listOf(row2Button1, row2Button2)
        val row3 = listOf(row3Button1)
        val rows = listOf(row1, row2, row3)

        return InlineKeyboardMarkup(rows)

    }
}