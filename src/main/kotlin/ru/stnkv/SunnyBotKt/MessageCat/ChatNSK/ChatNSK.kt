package ru.stnkv.SunnyBotKt.MessageCat.ChatNSK

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import ru.stnkv.SunnyBotKt.MakeResponse

class ChatNSK: MakeResponse() {
    override val CAPTION: String = "Новосибирцев и тех кто живет недалеко от города мы приглашаем в наш чат!\n" +
            "\n" +
            "У нас вы найдете:\n" +
            "<i>✅Приятное общение\n" +
            "✅Новые знакомства\n" +
            "✅Сходки клуба\n" +
            "✅Личные встречи</i>\n" +
            "\n" +
            "Внимание - это приватный чат!\n" +
            "\n" +
            "Для вступления необходимо подать заявку а после вступления и заполнить анкету."


    override fun getMenu(): InlineKeyboardMarkup {
        val row1Button1 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()

        row1Button1.text = "Вступить";
        row1Button1.url = "https://t.me/+7BMnh2TvFSFiMmE6";
        row2Button1.text = "Главное меню";
        row2Button1.callbackData = "MAIN_MENU_BACK";

        val row1 = listOf(row1Button1)
        val row2 = listOf(row2Button1)

        val rows = listOf(row1, row2)

        return InlineKeyboardMarkup(rows)
    }
}