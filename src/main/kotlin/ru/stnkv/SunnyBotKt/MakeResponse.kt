package ru.stnkv.SunnyBotKt

import org.telegram.telegrambots.meta.api.methods.ParseMode
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import java.io.File

open class MakeResponse {

    open val IMAGE_DIR = "/home/evgeny/docks/Image/MAIN_IMAGE.jpg"
    open val CAPTION = "Привет!\n" +
            "\n" +
            "Я бот - справочник по автомобилю <b>NISSAN SUNNY B15.</b>\n" +
            "\n" +
            "У меня можно <b><u>быстро и удобно</u></b> получить доступ к основной справочной информации!\n" +
            "\n" +
            "Такой как: <b>схемы, статьи, мануалы, информация для диагностики, расшифровки ошибок, расходники для ТО и много другое!</b>"

    //Новое сообщение
     fun getNewMessage(userID: String): SendPhoto {
        val message = SendPhoto()

        message.chatId = userID
        message.photo = InputFile(File(IMAGE_DIR))
        message.caption = CAPTION
        message.parseMode = ParseMode.HTML
        message.replyMarkup = getMenu()

        return message
    }


    //Изменение описания и меню
    fun getEditCaption(userID: String, messageID: Int): EditMessageCaption {
        val message = EditMessageCaption()

        message.chatId = userID
        message.messageId = messageID
        message.caption = CAPTION
        message.parseMode = ParseMode.HTML
        message.replyMarkup = getMenu()

        return message
    }

    //Изменение фото и меню
    fun getEditPhoto(userID: String, messageID: Int): EditMessageMedia {
        val message = EditMessageMedia()
        val media = InputMediaPhoto()

        media.setMedia(File(IMAGE_DIR), "MAIN_IMAGE.jpg")

        message.chatId = userID
        message.messageId = messageID
        message.media = media
        message.replyMarkup = getMenu()

        return message
    }

    open fun getMenu(): InlineKeyboardMarkup {

        val row1Button1 = InlineKeyboardButton()
        val row1Button2 = InlineKeyboardButton()
        val row2Button1 = InlineKeyboardButton()
        val row2Button2 = InlineKeyboardButton()
        val row3Button1 = InlineKeyboardButton()
        val row3Button2 = InlineKeyboardButton()
        val row4Button1 = InlineKeyboardButton()

        row1Button1.text = "Диагностика \uD83D\uDCF1"
        row1Button1.callbackData= "COMPUTER_DIAGNOSTIC_MAIN"
        row1Button2.text = "ТО и Расходники \uD83D\uDEE0"
        row1Button2.callbackData= "TO_MAIN"
        row2Button1.text = "Электрика ⚡️"
        row2Button1.callbackData= "ELECTRIC_MAIN"
        row2Button2.text = "Мануалы \uD83D\uDCD2"
        row2Button2.callbackData= "MANUAL_MAIN"
        row3Button1.text = "Доработки ⚙️"
        row3Button1.callbackData= "IMPROVEMENTS_MAIN"
        row3Button2.text = "Чат NSK \uD83C\uDF0E"
        row3Button2.callbackData= "NOVOSIBIRSK_CHAT"
        row4Button1.text = "О проекте ℹ\uFE0F"
        row4Button1.callbackData= "ABOUT_MAIN"

        val row1 = listOf(row1Button1, row1Button2)
        val row2 = listOf(row2Button1, row2Button2)
        val row3 = listOf(row3Button1, row3Button2)
        val row4 = listOf(row4Button1)

        val menuRows = listOf(row1, row2, row3, row4)

        return InlineKeyboardMarkup(menuRows)
    }


}