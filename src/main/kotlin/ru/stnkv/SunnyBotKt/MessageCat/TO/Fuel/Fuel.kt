package ru.stnkv.SunnyBotKt.MessageCat.TO.Fuel

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class Fuel: MakeResponse() {
    override val CAPTION: String = "Расходные материалы для технического обслуживания топливной системы.\n" +
            "\n" +
            "✅ <b>Топливный насос</b>\n" +
            "\n" +
            "<i>Номер запчасти - 17042-4M400</i>\n" +
            "\n" +
            "\n" +
            "✅ <b>Топливный фильтр (погружной)</b>\n" +
            "\n" +
            "✳\uFE0F <u>Дорестайлинг</u> - <i>Номер запчасти - 16400-4M405</i>\n" +
            "✳\uFE0F <u>Рестайлинг</u> - <i>Номер запчасти - 16400-2Y505</i>\n" +
            "\n" +
            "\n" +
            "✅ <b>Фильтр грубой очистки (сеточка)</b>\n" +
            "\n" +
            "<i>Номер запчасти - 17275-4M400</i>\n" +
            "\n" +
            "\n" +
            "✅ <b>Датчик уровня топлива</b>\n" +
            "\n" +
            "<i>Номер запчасти - 25060-4M400</i>"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()
        val row5Button1 = InlineKeyboardButton()
        val row6Button1 = InlineKeyboardButton()
        val row7Button1 = InlineKeyboardButton()
        val row7Button2 = InlineKeyboardButton()

        row1Button1.setText("Топливный насос");
        row1Button1.setUrl("https://yandex.ru/search?text=17042-4M400&source=tabbar&lr=11314");
        row2Button1.setText("Датчик уровня топлива");
        row2Button1.setUrl("https://yandex.ru/search/?text=250604M400&clid=2360950&win=650&lr=11314");
        row3Button1.setText("Фильтр сеточка");
        row3Button1.setUrl("https://yandex.ru/search/?text=172754M400&lr=11314&clid=2360950&win=650");
        row4Button1.setText("Фильтр дорестайлинг 2WD");
        row4Button1.setUrl("https://yandex.ru/search/?text=16400-4M405&lr=11314&clid=2360950&win=650");
        row5Button1.setText("Фильтр рестайлинг 2WD");
        row5Button1.setUrl("https://yandex.ru/search/?text=16400-2Y505&lr=11314&clid=2360950&win=650");
        row6Button1.setText("Фильтр для 4WD");
        row6Button1.setUrl("https://yandex.ru/search/?text=AY505-NS001&clid=2360950&win=650&lr=146702");
        row7Button1.setText("⬅️ Назад");
        row7Button1.setCallbackData("TO_MAIN");
        row7Button2.setText("Главное меню");
        row7Button2.setCallbackData("MAIN_MENU_BACK");

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1)
        val row4 = listOf(row4Button1)
        val row5 = listOf(row5Button1)
        val row6 = listOf(row6Button1)
        val row7 = listOf(row7Button1, row7Button2)

        val rows = listOf(row1, row2, row3, row4, row5, row6, row7)

        return InlineKeyboardMarkup(rows)
    }
}