package ru.stnkv.SunnyBotKt.MessageCat.Manual

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class Manual: MakeResponse() {
    override val CAPTION: String = "В это разделе лежит общая книга по ремонту автомобиля.\n" +
            "\n" +
            "А так же книга по ремонту двигателей QG13DE, QG15DE(LB), QG18DE(LB), QG18DD(Neo Di)"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()


        row1Button1.text = "✅ Читать общий мануал";
        row1Button1.url = "https://drive.google.com/file/d/1-IYKsJOqEPWjc8-4c1p2I2eluudshmBy/view?usp=drivesdk";
        row2Button1.text = "✅ Читать мануал по двигателям";
        row2Button1.url = "https://drive.google.com/file/d/1nriq6lnra5jS0TX3BhbJQqfVDdd2-FRY/view?usp=sharing";
        row3Button1.text = "Главное меню";
        row3Button1.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1)

        val rows = listOf(row1, row2, row3)

        return InlineKeyboardMarkup(rows)
    }
}