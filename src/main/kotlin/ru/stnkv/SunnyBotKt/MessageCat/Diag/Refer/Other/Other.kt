package ru.stnkv.SunnyBotKt.MessageCat.Diag.Refer.Other

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class Other: MakeResponse() {
    override val CAPTION: String = "Список показаний других датчиков и общих параметров:\n" +
            "\n" +
            "⚡\uFE0F Напряжение боротовой сети - 13.8V - 14.7V.\n" +
            "\n" +
            "✅ Время впрыска - 2.30мс - 2.45мс.\n" +
            "\n" +
            "✅ УОЗ - Как правило 6-10 градусов согласно наклейке на внутренней стороне капота.\n" +
            "\n" +
            "✅ Обороты ХХ - 650-750RPM согласно наклейке на внутренней стороне капота.\n" +
            "\n" +
            "✅ Напряжение ДПДЗ - Как правило в пределах 0.4V - 0.5V. При превышении 0.5V возникают НЕРЕШАЕМЫЕ проблемы с холостым ходом.\n" +
            "\n" +
            "✅ Давление топлива - На оборотах холостого хода ~3.4-3.8"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()


        row1Button1.text = "⬅️ Назад";
        row1Button1.callbackData = "BACK_TO_REFERENCES";
        row1Button2.text = "Главное меню";
        row1Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1, row1Button2)
        val rows = listOf(row1)

        return InlineKeyboardMarkup(rows)
    }

}