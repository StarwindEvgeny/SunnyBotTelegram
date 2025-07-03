package ru.stnkv.SunnyBotKt.MessageCat.Diag.Programs.TECU3

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class TECU3: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/TECU3.png"

    override val CAPTION: String = "<b>TECU3</b> - Программа диагностики для ПК.\n" +
            "\n" +
            "Плюсы:\n" +
            "\n" +
            "<i>✅ Бесплатная.\n" +
            "✅ Расширеный функционал (Адаптации, корректировки УОЗ, ХХ, Обучения).</i>\n" +
            "\n" +
            "Минусы:\n" +
            "\n" +
            "<i>❌ Сложный интерфейс.</i>\n"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row2Button2 = InlineKeyboardButton()

        row1Button1.text = "✅ Скачать TECU3";
        row1Button1.url = "https://disk.yandex.ru/d/bayJzpufp9pG2Q";
        row2Button1.text = "⬅️ Назад";
        row2Button1.callbackData = "BACK_TO_DIAGNOSTIC_PROGRAMS";
        row2Button2.text = "Главное меню";
        row2Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1, row2Button2)
        val rows = listOf(row1, row2)

        return InlineKeyboardMarkup(rows)
    }
}