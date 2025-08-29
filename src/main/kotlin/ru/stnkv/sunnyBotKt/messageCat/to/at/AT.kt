package ru.stnkv.sunnyBotKt.messageCat.to.at

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class AT {
    companion object {
        const val CAPTION: String = "Расходные материалы для технического обслуживания коробки передач.\n" +
                "\n" +
                "\n" +
                "✅ <b>АКПП</b>\n" +
                "\n" +
                "- Рекомендуемая замена ~60000 км.\n" +
                "\n" +
                "Заправочные обьемы:\n" +
                "\n" +
                "- Частичная замена без снятия поддона - <b>~3.5 литра.</b>\n" +
                "- Частичная замена со снятием поддона - <b>~4.5 литра.</b>\n" +
                "- Полная замена - <b>8 литров.</b>\n" +
                "\n" +
                "<i>- Трансмиссионая жидкость <b>ATF Nissan Matic Fluid D</b>\n" +
                "- Фильтр АКПП - <b>3172831X01</b>.\n" +
                "- Прокладка поддона АКПП - <b>3139731X02</b>.</i>\n" +
                "\n" +
                "\n" +
                "✅ <b>МКПП</b>\n" +
                "\n" +
                "- Рекомендуемая замена - <b>50000 км.</b>\n" +
                "- Заправочный обьем - <b>3 литра.</b>\n" +
                "\n" +
                "<i>Трансмиссионное масло <b>75w-90 GL-4, GL-4+, GL-4/5.</b></i>"


        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row2Button2 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row3Button2 = InlineKeyboardButton()

            row1Button1.text = "ATF АКПП"
            row1Button1.url = "https://yandex.ru/search/?text=ATF+Nissan+Matic+Fluid+D&lr=11314&clid=2360950&win=650"
            row1Button2.text = "Масло МКПП"
            row1Button2.url = "https://yandex.ru/search/?text=75w-90+GL-4&lr=11314&clid=2360950&win=650"
            row2Button1.text = "Фильтр АКПП"
            row2Button1.url = "https://yandex.ru/search/?text=3172831X01&lr=11314&clid=2360950&win=650"
            row2Button2.text = "Прокладка АКПП"
            row2Button2.url = "https://yandex.ru/search/?text=3139731X02&lr=11314&clid=2360950&win=650"
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