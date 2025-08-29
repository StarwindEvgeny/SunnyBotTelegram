package ru.stnkv.sunnyBotKt.messageCat.aboutProject

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class KeyWordsList {
    companion object {
        const val CAPTION: String = "Ключевые слова для быстрого перехода по меню.\n\n" +
                "Напишите одно из этих слов боту, в ответ получите сообщение с нужным разделом\n" +
                "\n" +
                "- ТО — Главное меню технического обслуживания\n\n" +
                "- Мануал — Меню с книгами по ремонту\n\n" +
                "- Устройства — Меню с устройствами для диагностики авто\n\n" +
                "- Программы — Меню с программами для диагностики авто\n\n" +
                "- ЕЛМ — Информация по ЕЛМ\n\n" +
                "- MAF или ДМРВ — Диагностика MAF SENSOR\n\n" +
                "- Ошибки — Информация об ошибках двигателя и их расшифровка\n\n" +
                "- Проект — Меню «О Проекте»\n\n" +
                "- Чат — Меню «Чат NSK»\n\n" +
                "- АКПП — Диагностика АКПП\n\n" +
                "- ABS — Диагностика ABS\n\n" +
                "- SRS — Диагностика подушек безопасности\n\n" +
                "- ЭБУ — Информация о блоках управления двигателем\n\n" +
                "- Предохранители — Информация о предохранителях и реле\n\n" +
                "- Лампы — Информация о лампах, применяемые в автомобиле"


        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()

            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "ABOUT_MAIN"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU_BACK"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}