package ru.stnkv.sunnyBotKt.messageCat.other

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.InputFile
import java.io.File

class Offense {
    companion object {
        const val IMAGE_DIR: String = "/home/evgeny/docks/Image/OFFENSE.jpg"

        const val CAPTION: String = ""

        fun getNewMessage(userID: String): SendPhoto {
            val message = SendPhoto()

            message.chatId = userID
            message.photo = InputFile(File(IMAGE_DIR))
            message.caption = CAPTION

            return message
        }
    }
}