package ru.stnkv.sunnyBotKt.messageCat.chatNSK

import org.telegram.telegrambots.meta.api.methods.ParseMode
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.InputFile
import java.io.File

class Greeting {
    companion object {
         const val IMAGE_DIR: String = "/home/evgeny/docks/Image/MAIN_IMAGE.jpg"
         const val CAPTION: String =
            "\nДобро пожаловать \uD83E\uDD1D в <b>Новосибирский клуб Nissan Sunny B15!</b>\n" +
                    "\n" +
                    "Если Вы из другого города и не планируете навещать нас, просьба покинуть группу, так или иначе Вы будете удалены\uD83E\uDD37\u200D♂\uFE0F\n" +
                    "\n" +
                    "Обязательно <b>представьтесь</b> участникам группы:\n" +
                    "<i>1. Имя, возраст.\n" +
                    "2. Район.\n" +
                    "3. Фото авто, можно и свое.</i>\n" +
                    "\n" +
                    "При игнорировании анкеты, участник будет удален.\n" +
                    "\n" +
                    "При использовании бота <b>ВЫЗЫВАТЬ СВОЕ СООБЩЕНИЕ</b> НЕ нажимать на чужое!"

        private var name = ""

        fun getGreeting(userID: String, userName: String?): SendPhoto {
            name = userName ?: ""

            val message = SendPhoto()

            message.chatId = userID
            message.photo = InputFile(File(IMAGE_DIR))
            message.caption = "@$name\n$CAPTION"
            message.parseMode = ParseMode.HTML

            return message
        }
    }
}