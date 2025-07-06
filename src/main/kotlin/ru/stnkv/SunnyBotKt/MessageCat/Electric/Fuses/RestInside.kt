package ru.stnkv.SunnyBotKt.MessageCat.Electric.Fuses

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class RestInside: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/REST_SALOON.jpg"

    override val CAPTION: String = "Блок предохранителей в салоне FB15 рестайлинг 24350-8N000.\n" +
            "\n" +
            "1-я строка слева на право:\n" +
            "✅ 10А ACC — зеркала, магнитола, acc\n" +
            "✅ 15А BAT — Лампы стоп-сигналов\n" +
            "✅ 10А BAT — Аварийная сигнализация.\n" +
            "✅ 20А BAT — Обогрев заднего стекла.\n" +
            "✅ 10А IGN — электронные компоненты (Доп. устройства).\n" +
            "✅ 10А IGN — Управление коробкой.\n" +
            "\n" +
            "2-я строка:\n" +
            "✅ 10A BAT — Доп.устройства, сигналка\n" +
            "✅ 10А BAT — Освещение салона.\n" +
            "✅ 15А IGN — Отопитель передний.\n" +
            "✅ 10А IGN — Кондиционер.\n" +
            "✅ 15А IGN — Отопитель передний.\n" +
            "✅ 10А IGN — Система управление двигателем 2.\n" +
            "✅ 10А IGN — Айрбэг.\n" +
            "✅ 10А IGN — Система управление двигателем 1.\n" +
            "\n" +
            "3-я строка:\n" +
            "✅ 10А ST — Стартер.\n" +
            "✅ 15А ACC — Прикуриватель.\n" +
            "✅ 20А IGN — Дворники передние.\n" +
            "✅ 10А IGN — Указатели поворота.\n" +
            "✅ 10А IGN — Дворник задний.\n" +
            "✅ 15А IGN — Топливный насос.\n" +
            "✅ 10А IGN — Комбинация приборов.\n" +
            "✅ 10А IGN — ABS."

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