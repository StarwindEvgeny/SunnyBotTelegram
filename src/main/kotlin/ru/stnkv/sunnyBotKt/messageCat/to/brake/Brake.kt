package ru.stnkv.sunnyBotKt.messageCat.to.brake

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class Brake {
    companion object {
        const val CAPTION: String = "Расходные материалы для технического обслуживания тормозной системы.\n" +
                "\n" +
                "\n" +
                "✅ <b>Тормозная жидкость</b>\n" +
                "\n" +
                "- Рекомендуемая замена - 60000 км. или 2 года.\n" +
                "- Заправочный обьем - 1 литр.\n" +
                "\n" +
                "<i>Тормозная жидкость - DOT4</i>\n" +
                "\n" +
                "✅ <b>Тормозные колодки</b>\n" +
                "\n" +
                "- Рекомендуемая замена:\n" +
                "\n" +
                "<i>Передние</i> - 30000 км.\n" +
                "<i>Номер запчасти - PF-2435</i>\n" +
                "\n" +
                "<i>Задние</i> - 60000 км.\n" +
                "<i>Номер запчасти - AY360-NS102</i>\n" +
                "\n" +
                "✅ <b>Тормозные диски</b>\n" +
                "\n" +
                "- Рекомендуемая замена - 100000 км.\n" +
                "\n" +
                "<i>Номер запчасти - 402064M402</i>"

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row2Button2 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row3Button2 = InlineKeyboardButton()

            row1Button1.text = "Тормозная жидкость"
            row1Button1.url = "https://yandex.ru/search/?text=DOT4&lr=11314&clid=2360950&win=650"
            row1Button2.text = "Тормозные диски"
            row1Button2.url = "https://yandex.ru/search/?text=402064M402&lr=11314&clid=2360950&win=650"
            row2Button1.text = "Передние колодки"
            row2Button1.url = "https://yandex.ru/search/?text=PF-2435&lr=11314&clid=2360950&win=650"
            row2Button2.text = "Задние колодки"
            row2Button2.url = "https://yandex.ru/search/?text=AY360-NS102&lr=11314&clid=2360950&win=650"
            row3Button1.text = "⬅️ Назад"
            row3Button1.callbackData = "TO_MAIN"
            row3Button2.text = "Главное меню"
            row3Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val row2 = listOf(row2Button1, row2Button2)
            val row3 = listOf(row3Button1, row3Button2)

            val rows = listOf(row1, row2, row3)

            return InlineKeyboardMarkup(rows)
        }
    }
}