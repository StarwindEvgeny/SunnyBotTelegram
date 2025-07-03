package ru.stnkv.SunnyBotKt.MessageCat.Other

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.InputFile
import ru.stnkv.SunnyBotKt.MakeResponse
import java.io.File

class Offense: MakeResponse() {
    override val IMAGE_DIR: String = "/home/evgeny/docks/Image/OFFENSE.jpg"

    override val CAPTION: String = ""

    override fun getNewMessage(userID: String): SendPhoto {
        val message = SendPhoto()

        message.chatId = userID
        message.photo = InputFile(File(IMAGE_DIR))
        message.caption = CAPTION

        return message
    }
}