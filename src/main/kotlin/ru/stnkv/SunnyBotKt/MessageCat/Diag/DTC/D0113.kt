package ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class D0113: MakeResponse() {
    override val CAPTION: String = "Ошибка P0113 указывает на отказ датчика температуры всасываемого воздуха в двигателе.\n" +
            "\n" +
            "Возможные причины появления ошибки:\n" +
            "\n" +
            "<i>- Пропал контакт в разъёме питания.\n" +
            "- Обрыв провода датчика IAT.\n" +
            "- Загрязнение масляными отложениями.\n" +
            "- Выход из строя датчика температуры всасываемого воздуха.\n" +
            "- Переделана фишка под датчик BOSH.</i>\n" +
            "\n" +
            "Для устранения ошибки рекомендуется:\n" +
            "\n" +
            "<i>- Проверить контакты в разъёме и проводку датчика поступающего воздуха в двигатель (возможно, есть окисление или обрыв).\n" +
            "- Прочистить чувствительный элемент карбклинером.\n" +
            "- Заменить датчик воздуха, если вышеописанные процедуры не помогли.</i>"

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