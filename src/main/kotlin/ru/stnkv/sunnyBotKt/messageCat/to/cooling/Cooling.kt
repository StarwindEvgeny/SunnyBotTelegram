package ru.stnkv.sunnyBotKt.messageCat.to.cooling

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class Cooling {
    companion object {
        const val CAPTION: String = "Расходные материалы для технического обслуживания системы охлаждения автомобиля.\n" +
                "\n" +
                "\n" +
                "✅ <b>Антифриз</b>\n" +
                "\n" +
                "- Рекомендуемая замена - 50000 км.\n" +
                "- Заправочный обьем - 7 литров.\n" +
                "\n" +
                "<i>Тип антифриза - G12++ или G13</i>\n" +
                "\n" +
                "\n" +
                "✅ <b>Крышка радиатора</b>\n" +
                "\n" +
                "<i>Номер запчасти - 2143001F02</i>"


        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row2Button2 = InlineKeyboardButton()

            row1Button1.text = "Антифриз"
            row1Button1.url = "https://yandex.ru/search/?text=antifreeze+g12%2B%2B&lr=11314&clid=2360950&win=650"
            row1Button2.text = "Крышка радиатора"
            row1Button2.url = "https://yandex.ru/search/?text=2143001F02&lr=11314&clid=2360950&win=650"
            row2Button1.text = "⬅️ Назад"
            row2Button1.callbackData = "TO_MAIN"
            row2Button2.text = "Главное меню"
            row2Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val row2 = listOf(row2Button1, row2Button2)

            val rows = listOf(row1, row2)

            return InlineKeyboardMarkup(rows)
        }
    }
}