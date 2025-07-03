package ru.stnkv.SunnyBotKt.MessageCat.Diag.Programs.Econ

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class Econ: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/EconTool.png"

    override val CAPTION: String = "<b>EconTool</b>\n" +
            "\n" +
            "<i>✅ Прочитать ошибки двигателя.\n" +
            "✅ Очистить ошибки двигателя.\n" +
            "✅ Просматривать параметры в режиме реального времени.\n" +
            "❌ Нет на iPhone</i>\n" +
            "\n" +
            "Существуют платные модули, которые действительно расширяют функциал дают доступ к:\n" +
            "\n" +
            "<i>✅ Корректировка УОЗ и оборотов ХХ\n" +
            "✅ Сброс адаптаций\n" +
            "✅ Обучение ДЗ (Рестайлинг от 2002 г.в)\n" +
            "✅ Активные тесты (подмена показаний датчиков в режиме реального времени)</i>"

    override fun getMenu(): InlineKeyboardMarkup {

        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row3Button2 = InlineKeyboardButton()

        row1Button1.text = "✅ GOOGLE PLAY";
        row1Button1.url = "https://play.google.com/store/apps/details?id=com.scobasoft.econtool";
        row2Button1.text = "Официальный телеграмм канал";
        row2Button1.url = "https://t.me/econtool";
        row3Button1.text = "⬅️ Назад";
        row3Button1.callbackData = "BACK_TO_DIAGNOSTIC_PROGRAMS";
        row3Button2.text = "Главное меню";
        row3Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1, row3Button2)

        val rows = listOf(row1, row2, row3)

        return InlineKeyboardMarkup(rows)
    }
}