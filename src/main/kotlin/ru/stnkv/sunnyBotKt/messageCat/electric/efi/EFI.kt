package ru.stnkv.sunnyBotKt.messageCat.electric.efi

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class EFI {
    companion object {
        const val IMAGE_DIR: String = "/home/evgeny/docks/Image/EFI.jpg"
        const val CAPTION: String =
            "Для верного выбора блока управления обратите внимание на прошивку блока (обведено красным) \n" +
                    "\n" +
                    "Подбирайте блок управления с такой же или смежной прошивкой (AD, Wingroad).\n" +
                    "\n" +
                    "Если нет возможности узнать тип прошивки блока: ниже приведены основные конфигурации для той или иной прошивки.\n" +
                    "\n" +
                    "\n❗\uFE0FДОРЕСТАЙЛИНГ\n\n" +
                    "❇\uFE0F А5\n\n" +
                    "- МКПП\n" +
                    "- LeanBurn (ECO LAMP)\n" +
                    "- MAF Sensor - 4 контакта\n" +
                    "- Базовый УОЗ 2гр. 630 об/м\n" +
                    "\n" +
                    "❇\uFE0F А7\n\n" +
                    "- АКПП\n" +
                    "- LeanBurn (ECO LAMP)\n" +
                    "- MAF SENSOR - 4 контакта\n" +
                    "- Базовый УОЗ 6гр. 750 об/м\n\n" +
                    "❇\uFE0F ZU \n\n" +
                    "- МКПП\n" +
                    "- MAF SENSOR - 5 контактов\n" +
                    "- ЕГР с датчиком температуры\n" +
                    "- Базовый УОЗ 2гр.\n\n" +
                    "❇\uFE0F ZZ \n\n" +
                    "- АКПП\n" +
                    "- MAF SENSOR - 5 контактов\n" +
                    "- ЕГР с датчиком температуры\n" +
                    "- Базовый уоз 10гр. 700 об/м\n\n" +
                    "❗\uFE0FРЕЙСТАЙЛИНГ\n\n" +
                    "❇\uFE0F LQ\n\n" +
                    "- АКПП\n" +
                    "- MAF SENSOR BOSH 5 Контактов\n" +
                    "- Базовый УОЗ 10гр. 700 об/м\n\n" +
                    "❇\uFE0F ZW (Смежный блок 3U)\n\n" +
                    "- АКПП\n" +
                    "- MAF SENSOR HITACHI 4 Контакта\n" +
                    "- Базовый УОЗ 10гр. 700 об/м\n\n"

        fun getMenu(): InlineKeyboardMarkup {
            val row1Button1 = InlineKeyboardButton()
            val row1Button2 = InlineKeyboardButton()

            row1Button1.text = "⬅️ Назад"
            row1Button1.callbackData = "ELECTRIC_MAIN_BACK"
            row1Button2.text = "Главное меню"
            row1Button2.callbackData = "MAIN_MENU"

            val row1 = listOf(row1Button1, row1Button2)
            val rows = listOf(row1)

            return InlineKeyboardMarkup(rows)
        }
    }
}