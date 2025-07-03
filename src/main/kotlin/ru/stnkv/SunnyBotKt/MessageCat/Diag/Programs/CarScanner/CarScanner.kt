package ru.stnkv.SunnyBotKt.MessageCat.Diag.Programs.CarScanner

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class CarScanner: MakeResponse() {

    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/CARSCANNER.jpg"

    override val CAPTION: String = "<b>CarScanner</b> - простая и удобная \"читалка\", с ее помощью можно:\n" +
            "\n" +
            "✅ Прочитать ошибки двигателя.\n" +
            "✅ Очистить ошибки двигателя.\n" +
            "✅ Просматривать параметры в режиме реального времени\n" +
            "\n" +
            "\n" +
            "❌ Есть платные модули\n" +
            "✅ Они бесполезны и не нужны\n" +
            "\n" +
            "Для <b>ПЕРВОГО</b> подключения выполнить следующее:\n" +
            "<i>1. Перейти в настройки\n" +
            "2. Раздел \"Профиль подключения\"\n" +
            "3. Выбрать NISSAN CONSULT II</i>"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()
        val row4Button2 = InlineKeyboardButton()


        row1Button1.text = "✅ GOOGLE PLAY";
        row1Button1.url = "https://play.google.com/store/apps/details?id=com.ovz.carscanner";
        row2Button1.text = "✅ APPSTORE";
        row2Button1.url = "https://apps.apple.com/ru/app/car-scanner-elm-obd2/id1259933623";
        row3Button1.text = "Официальный сайт";
        row3Button1.url = "https://www.carscanner.info/ru/";
        row4Button1.text = "⬅️ Назад";
        row4Button1.callbackData = "BACK_TO_DIAGNOSTIC_PROGRAMS";
        row4Button2.text = "Главное меню";
        row4Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1)
        val row4 = listOf(row4Button1, row4Button2)

        val rows = listOf(row1, row2, row3, row4)

        return InlineKeyboardMarkup(rows)
    }
}