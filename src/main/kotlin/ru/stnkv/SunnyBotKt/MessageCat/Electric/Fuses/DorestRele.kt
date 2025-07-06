package ru.stnkv.SunnyBotKt.MessageCat.Electric.Fuses

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class DorestRele: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/DOREST_OUTSIDE_2.jpg"

    override val CAPTION: String = "Блок реле в моторном отсеке FB15 Дорестайлинг.\n" +
            "\n" +
            "\n" +
            "✅ FR FOG LAMP — <i>Реле противотуманных фар.</i>\n" +
            "\n" +
            "✅ INHIBIT CLUTCH INTER LOCK — <i>Реле запрещения запуска (\"Р''/''N\").</i>\n" +
            "\n" +
            "✅ AIR CON — <i>Реле системы кондиционирования.</i>\n" +
            "\n" +
            "✅ HORN — <i>Реле звукового сигнала.</i>\n" +
            "\n" +
            "✅ RAD FAN — <i>Реле электродвигателя вентилятора системы охлаждения.</i>"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()


        row1Button1.text = "⬅️ Назад";
        row1Button1.callbackData = "FUSES_INFO_BACK";
        row1Button2.text = "Главное меню";
        row1Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1, row1Button2)
        val rows = listOf(row1)

        return InlineKeyboardMarkup(rows)
    }
}