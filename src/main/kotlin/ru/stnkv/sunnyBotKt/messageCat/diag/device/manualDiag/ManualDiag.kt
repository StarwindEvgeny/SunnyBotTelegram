package ru.stnkv.sunnyBotKt.messageCat.diag.device.manualDiag

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class ManualDiag {
    companion object {
         const val IMAGE_DIR: String = "/home/evgeny/docks/Image/ManualDiagnostic.jpg"
         const val CAPTION: String = "Для того что бы прочитать код неисправности делаем следующее:\n" +
                "\n" +
                "<i>1. Проверить что педаль акселератора (газ) полностью отжата (отпущена).\n" +
                "2. Включить зажигание но НЕ запускать двигатель.\n" +
                "3. Ожидать 3 секунды.\n" +
                "4. В течение следующих 5 секунд полностью нажать, а затем полностью отпустить педаль акселератора 5 раз.\n" +
                "5. Ожидать 7 секунд.\n" +
                "6. Полностью нажать педаль акселератора и так держать в течение 10 секунд.\n" +
                "7. Лампа \"Check Engine Light\" на панели приборов (неисправности двигателя) начнет мигать, сообщая код неисправности. Полностью отпустить педаль акселератора.\n" +
                "7.1. На картинке приведены примеры \"миганий\" лампы при разных кодах неисправностей</i>\n" +
                "\n" +
                "\n" +
                "Для того что бы стереть коды неисправностей:\n" +
                "<i>- После того как код ошибки отмигает, нажать на педаль акселератора и держать в течении 10 сек. — выключить зажигание.</i>"


         fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()

            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "BACK_TO_DIAGNOSTIC_DEVICES"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}