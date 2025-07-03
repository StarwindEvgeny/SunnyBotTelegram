package ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.ELM

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class ELM: MakeResponse() {
    override val CAPTION: String = "Компактное устройство, которое удобно возить с собой.\n" +
            "\n" +
            "Для успешного подключения ELM327 должна обладать следущими праметрами:\n" +
            "\n" +
            "✅ Версия - v1.5.\n" +
            "✅ Количество плат - 2.\n" +
            "✅ Чип - PIC18F25K80\n" +
            "\n" +
            "Только такая конфигурация ГАРАНТИРУЕТ стабильное подключение к блоку управления!"
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/ELM327.jpg"

    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()
        val row4Button2 = InlineKeyboardButton()


        row1Button1.text = "✅ Найти на WB";
        row1Button1.url = "https://www.wildberries.ru/catalog/0/search.aspx?search=elm327%201.5%20pic18f25k80";
        row2Button1.text = "✅ Найти на OZON";
        row2Button1.url = "https://www.ozon.ru/category/elm327-1-5-pic18f25k80/";
        row3Button1.text = "✅ Искать в интернете";
        row3Button1.url = "https://yandex.ru/search/?text=elm327+1.5+pic18f25k80&lr=11314&clid=2360950&win=650&src=suggest_T";
        row4Button1.text = "⬅️ Назад";
        row4Button1.callbackData = "BACK_TO_DIAGNOSTIC_DEVICES";
        row4Button2.text = "Главное меню";
        row4Button2.callbackData = "MAIN_MENU";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)
        val row3 = listOf(row3Button1)
        val row4 = listOf(row4Button1, row4Button2)

        val rows = listOf(row1, row2, row3, row4)

        return InlineKeyboardMarkup(rows)
    }
}