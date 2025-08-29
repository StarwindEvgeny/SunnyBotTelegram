package ru.stnkv.sunnyBotKt

import org.telegram.telegrambots.meta.api.methods.ParseMode
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import java.io.File

class MakeResponse {
    companion object {

        //Новое сообщение
        fun getNewMessage
        (
            userID: String,
            imageDir: String,
            caption: String,
            menu: InlineKeyboardMarkup
        ): SendPhoto
        {
            val message = SendPhoto()

            message.chatId = userID
            message.photo = InputFile(File(imageDir))
            message.caption = caption
            message.parseMode = ParseMode.HTML
            message.replyMarkup = menu

            return message
        }


        //Изменение описания и меню
        fun getEditCaption
        (
            userID: String,
            messageID: Int,
            caption: String,
            menu: InlineKeyboardMarkup
        ): EditMessageCaption
        {
            val message = EditMessageCaption()

            message.chatId = userID
            message.messageId = messageID
            message.caption = caption
            message.parseMode = ParseMode.HTML
            message.replyMarkup = menu

            return message
        }

        //Изменение фото и меню
        fun getEditPhoto
        (
            userID: String,
            messageID: Int,
            imageDir: String,
            menu: InlineKeyboardMarkup
        ): EditMessageMedia
        {
            val message = EditMessageMedia()
            val media = InputMediaPhoto()

            media.setMedia(File(imageDir), "MAIN_IMAGE.jpg")

            message.chatId = userID
            message.messageId = messageID
            message.media = media
            message.replyMarkup = menu

            return message
        }
    }
}