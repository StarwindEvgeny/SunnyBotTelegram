package ru.stnkv.sunnyBotKt.messageCat.to.engine

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class Engine {
    companion object {
        const val CAPTION: String = "Расходные материалы для технического обслуживания двигателя:\n" +
                "\n" +
                "Для поиска используйте кнопки под сообщением.\n" +
                "\n" +
                "✅ <b>Моторное масло</b>\n" +
                "\n" +
                "- Рекомендуемая замена 5000 - 8000км.\n" +
                "- Заправочный обьем - 2.7 - 3 литра.\n" +
                "\n" +
                "<i>5w-30 Стандарты API SP и ILSAC GF-6.</i>\n" +
                "\n" +
                "✅ <b>Масляный фильтр</b>\n" +
                "\n" +
                "- Рекомендуемая замена: во время замены моторного масла\n" +
                "\n" +
                "<i>- Номер запчасти -  AY100-NS004</i>\n" +
                "\n" +
                "✅ <b>Воздушный фильтр</b>\n" +
                "\n" +
                "- Рекомендуемая замена: во время замены моторного масла\n" +
                "\n" +
                "<i>- Номер запчасти - AY120-NS001.</i>\n" +
                "\n" +
                "✅ <b>Свечи зажигания</b>\n" +
                "\n" +
                "- Рекомендуемая замена: один раз в год (как правило перед зимним периодом)\n" +
                "\n" +
                "✳\uFE0F ДОРЕСТАЙЛИНГ\n" +
                "\n" +
                "<i>- Размер резьбы - М14\n" +
                "- Длина резьбы - 19 мм\n" +
                "\n" +
                "Примеры: NGK BKR5E11, DENSO K16PRU11б, Torch KH5RIU11.</i>\n" +
                "\n" +
                "✳\uFE0F РЕСТАЙЛИНГ\n" +
                "\n" +
                "<i>- Размер резьбы - М14\n" +
                "- Длина резьбы - 26.5 мм\n" +
                "\n" +
                "Примеры: NGK LFR5A-11.</i>"


        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()
            val row2Button1 = InlineKeyboardButton()
            val row2Button2 = InlineKeyboardButton()
            val row3Button1 = InlineKeyboardButton()
            val row4Button1 = InlineKeyboardButton()
            val row4Button2 = InlineKeyboardButton()

            row1Button1.text = "Масло"
            row1Button1.url = "https://yandex.ru/search/?text=5w-30+API+SP+&lr=11314&clid=2360950&win=650"
            row1Button2.text = "Масляный фильтр"
            row1Button2.url = "https://yandex.ru/search/?text=AY100-NS00&lr=11314&clid=2360950&win=650"
            row2Button1.text = "Свечи дорестайлинг"
            row2Button1.url = "https://yandex.ru/search/?text=BKR5E11&lr=11314&clid=2360950&win=650"
            row2Button2.text = "Свечи рестайлинг"
            row2Button2.url = "https://yandex.ru/search/?text=NGK+LFR5A-11&lr=11314&clid=2360950&win=650"
            row3Button1.text = "Воздушный фильтр"
            row3Button1.url = "https://yandex.ru/search/?text=AY120-NS001&lr=11314&clid=2360950&win=650"
            row4Button1.text = "⬅️ Назад"
            row4Button1.callbackData = "TO_MAIN"
            row4Button2.text = "Главное меню"
            row4Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val row2 = listOf(row2Button1, row2Button2)
            val row3 = listOf(row3Button1)
            val row4 = listOf(row4Button1, row4Button2)

            val rows = listOf(row1, row2, row3, row4)

            return InlineKeyboardMarkup(rows)
        }
    }
}