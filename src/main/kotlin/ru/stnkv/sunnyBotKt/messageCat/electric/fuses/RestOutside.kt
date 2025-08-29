package ru.stnkv.sunnyBotKt.messageCat.electric.fuses

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class RestOutside {
    companion object {
        const val IMAGE_DIR: String = "/home/evgeny/docks/Image/RestOutside.png"

        const val CAPTION: String = "Блок предохранителей в моторном отсеке FB15 рестайлинг 8N200.\n" +
                "\n" +
                "\n" +
                "✅ FL 40A ABS MTR — Мотор АБС.\n" +
                "\n" +
                "✅ FL 40A IGN SW — Замок зажигания.\n" +
                "\n" +
                "✅ FL 40A ABS SOL — Датчик АБС.\n" +
                "\n" +
                "✅ FL 30A RAD FAN1 — Вентилятор радиатора левый.\n" +
                "\n" +
                "✅ FL 30A POWER WINDOW — Эл. стеклоподъемники.\n" +
                "\n" +
                "✅ FL 30A RAD FAN2 — Вентилятор радиатора правый.\n" +
                "\n" +
                "✅ FL 60A BATTERY IGN — Зарядка аккумулятора.\n" +
                "\n" +
                "✅ FL 15A IGN COIL — Катушки зажигания.\n" +
                "\n" +
                "✅ FL 10A ECCS — Электронная система управления двигателем.\n" +
                "\n" +
                "✅ FL 15A MOTOR — Нагреватель лямбда-зонда.\n" +
                "\n" +
                "✅ FL 15A AUDIO — Aудиосистема.\n" +
                "\n" +
                "✅ FL 10A HORN — Сигнал.\n" +
                "\n" +
                "✅ FL 10A TAIL LAMP — Задний свет.\n" +
                "\n" +
                "✅ FL 15A H/LAMP RH — Правая фара.\n" +
                "\n" +
                "✅ FL 15A H/LAMP LH — Левая фара.\n" +
                "\n" +
                "✅ FL 15A WIPDEL CER — Обогрев щеток стеклоочистителя.\n" +
                "\n" +
                "✅ FL 15A FR FOG L — Противотуманки.\n" +
                "\n" +
                "✅ FL 100A BATTERY — Генератор."

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()


            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "FUSES_INFO_BACK"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}