package ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.VAGCOM

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class VAGCOM: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/VAGCOMKKL.jpg"
    override val CAPTION: String = "Кабель для подключения к ПК или ноутбуку.\n" +
            "\n" +
            "✅ Невысокая цена\n" +
            "✅ Легко найти\n" +
            "✅ Покупать на чипах <b>CH340 ИЛИ FTDI</b>"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()
        val row4Button2 = InlineKeyboardButton()


        row1Button1.text = "✅ Найти на WB";
        row1Button1.url = "https://www.wildberries.ru/catalog/0/search.aspx?search=VAG%20COM%20FTDI";
        row2Button1.text = "✅ Найти на OZON";
        row2Button1.url = "https://www.ozon.ru/category/testery-avtomobilnye-8663/?category_was_predicted=true&deny_category_prediction=true&from_global=true&text=VAG+COM+FTDI";
        row3Button1.text = "✅ Искать в интернете";
        row3Button1.url = "https://yandex.ru/search/?text=vag+com+kkl+409.1&clid=2360950&win=650&lr=11314";
        row4Button1.text = "⬅️ Назад";
        row4Button1.callbackData = "BACK_TO_DIAGNOSTIC_DEVICES";
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