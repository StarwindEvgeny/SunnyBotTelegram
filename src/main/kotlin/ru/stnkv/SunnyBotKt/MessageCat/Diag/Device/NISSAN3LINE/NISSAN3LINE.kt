package ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.NISSAN3LINE

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class NISSAN3LINE: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/NISSAN3LINE.jpg"
    override val CAPTION: String = "Кабель для подключения к ПК или ноутбуку.\n" +
            "\n" +
            "Плюсы:\n" +
            "✅ Отличается расширеным функционалом.\n" +
            "✅ Поддержка Rx Tx, поэтому способен читать блоки АКПП, ABS, SRS.\n" +
            "\n" +
            "Минусы:\n" +
            "❌ Цена.\n" +
            "❌ Не найти на маркетплейсах."

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row2Button2 = InlineKeyboardButton()

        row1Button1.text = "✅ Искать в интернете";
        row1Button1.url = "https://yandex.ru/search/?text=NISSAN3LINE";
        row2Button1.text = "⬅️ Назад";
        row2Button1.callbackData = "BACK_TO_DIAGNOSTIC_DEVICES";
        row2Button2.text = "Главное меню";
        row2Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1, row2Button2)
        val rows = listOf(row1, row2)

        return InlineKeyboardMarkup(rows)
    }
}