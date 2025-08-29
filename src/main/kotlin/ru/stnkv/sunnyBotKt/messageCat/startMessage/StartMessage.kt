package ru.stnkv.sunnyBotKt.messageCat.startMessage

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class StartMessage {
    companion object {
         const val IMAGE_DIR = "/home/evgeny/docks/Image/MAIN_IMAGE.jpg"
         const val CAPTION = "Привет!\n" +
                "\n" +
                "Я бот - справочник по автомобилю <b>NISSAN SUNNY B15.</b>\n" +
                "\n" +
                "У меня можно <b><u>быстро и удобно</u></b> получить доступ к основной справочной информации!\n" +
                "\n" +
                "Такой как: <b>схемы, статьи, мануалы, информация для диагностики, расшифровки ошибок, расходники для ТО и много другое!</b>"


         fun getMenu(): InlineKeyboardMarkup {

            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row2Button2 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row3Button2 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()

            row1Button1.text = "Диагностика \uD83D\uDCF1"
            row1Button1.callbackData = "COMPUTER_DIAGNOSTIC_MAIN"
            row1Button2.text = "ТО и Расходники \uD83D\uDEE0"
            row1Button2.callbackData = "TO_MAIN"
            row2Button1.text = "Электрика ⚡️"
            row2Button1.callbackData = "ELECTRIC_MAIN"
            row2Button2.text = "Мануалы \uD83D\uDCD2"
            row2Button2.callbackData = "MANUAL_MAIN"
            row3Button1.text = "Доработки ⚙️"
            row3Button1.callbackData = "IMPROVEMENTS_MAIN"
            row3Button2.text = "Чат NSK \uD83C\uDF0E"
            row3Button2.callbackData = "NOVOSIBIRSK_CHAT"
            row4Button1.text = "О проекте ℹ\uFE0F"
            row4Button1.callbackData = "ABOUT_MAIN"

            val row1 = listOf(row1Button1, row1Button2)
            val row2 = listOf(row2Button1, row2Button2)
            val row3 = listOf(row3Button1, row3Button2)
            val row4 = listOf(row4Button1)

            val menuRows = listOf(row1, row2, row3, row4)

            return InlineKeyboardMarkup(menuRows)
        }
    }
}