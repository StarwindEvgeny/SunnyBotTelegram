package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class D1217: MakeResponse() {
    override val CAPTION: String = "P1217 (Nissan) — двигатель перегрелся.\n" +
            "\n" +
            "Возможные причины:\n" +
            "\n" +
            "<i>- неисправный термостат;\n" +
            "- неисправный двигатель вентилятора охлаждения;\n" +
            "- жгут проводов вентилятора охлаждения открыт или замкнут;\n" +
            "- неисправное электрическое соединение в цепи вентилятора охлаждения;\n" +
            "- программа модуля управления двигателем (ECM);\n" +
            "- протекающий шланг радиатора;\n" +
            "- протекающий или забитый радиатор;\n" +
            "- крышка радиатора;\n" +
            "- утечка или повреждение водяного насоса.</i>"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()

        row1Button1.text = "⬅️ Назад";
        row1Button1.callbackData = "DECODING_ERRORS_INFO";
        row1Button2.text = "Главное меню";
        row1Button2.callbackData = "MAIN_MENU_BACK";

        val row1 = listOf(row1Button1, row1Button2)
        val rows = listOf(row1)

        return InlineKeyboardMarkup(rows)
    }
}