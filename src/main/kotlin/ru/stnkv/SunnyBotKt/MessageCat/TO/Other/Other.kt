package ru.stnkv.SunnyBotKt.MessageCat.TO.Other

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class Other: MakeResponse() {
    override val CAPTION: String = "Другие расходные материалы\n" +
            "\n" +
            "✅ <b>Гидроусилитель руля</b>\n" +
            "\n" +
            "- Заправочныый обьем - 1 литр.\n" +
            "- DEXTRON III или PSF\n" +
            "\n" +
            "✅ <b>Раздаточная коробка (4WD)</b>\n" +
            "\n" +
            "- Заправочный обьем - 0.5 литра.\n" +
            "- Трансмиссионное масло 80w-90 GL-5.\n" +
            "\n" +
            "✅ <b>Задний редуктор (4WD)</b>\n" +
            "\n" +
            "- Заправочный обьем - 1 литр.\n" +
            "- Трансмиссионное масло 80w-90 GL-5\n" +
            "\n" +
            "✅ <b>Щетки стеклоочистителей</b>\n" +
            "\n" +
            "- Заводской размер 525мм 380мм\n" +
            "- Позволяет установить до 600мм 400мм"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row2Button2 = InlineKeyboardButton()

        row1Button1.text = "Жидкость ГУР";
        row1Button1.url = "https://yandex.ru/search/?text=PSF&lr=11314&clid=2360950&win=650";
        row1Button2.text = "Масло";
        row1Button2.url = "https://yandex.ru/search/?text=80w-90+GL-5.&lr=11314&clid=2360950&win=650";
        row2Button1.text = "⬅️ Назад";
        row2Button1.callbackData = "TO_MAIN";
        row2Button2.text = "Главное меню";
        row2Button2.callbackData = "MAIN_MENU_BACK";

        val row1 = listOf(row1Button1, row1Button2)
        val row2 = listOf(row2Button1, row2Button2)

        val rows = listOf(row1, row2)

        return InlineKeyboardMarkup(rows)
    }
}