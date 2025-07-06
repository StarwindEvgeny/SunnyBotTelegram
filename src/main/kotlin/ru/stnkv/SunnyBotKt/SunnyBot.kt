package ru.stnkv.SunnyBotKt

import kotlinx.coroutines.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia
import org.telegram.telegrambots.meta.api.objects.Update
import ru.stnkv.SunnyBotKt.MessageCat.AboutProject.About
import ru.stnkv.SunnyBotKt.MessageCat.AboutProject.KeyWordsList
import ru.stnkv.SunnyBotKt.MessageCat.ChatNSK.ChatNSK
import ru.stnkv.SunnyBotKt.MessageCat.ChatNSK.Greeting
import ru.stnkv.SunnyBotKt.MessageCat.Diag.ABSDiag.ABSDiag
import ru.stnkv.SunnyBotKt.MessageCat.Diag.ABSDiag.ABSErrors
import ru.stnkv.SunnyBotKt.MessageCat.Diag.ATDiag.ATDiag
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0100
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0113
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0115
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0130
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0325
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0335
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0340
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0400
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0500
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D0600
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D1217
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.D1320
import ru.stnkv.SunnyBotKt.MessageCat.Diag.DTC.DTCMain
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.DeviceMain
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.ELM.ELM
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.ManualDiag.ManualDiag
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.NISSAN3LINE.NISSAN3LINE
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Device.VAGCOM.VAGCOM
import ru.stnkv.SunnyBotKt.MessageCat.Diag.MainDiag
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Programs.CarScanner.CarScanner
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Programs.Econ.Econ
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Programs.ProgramsMain
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Programs.TECU3.TECU3
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Refer.MAF.MAF
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Refer.Other.Other
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Refer.OxySensor.OxySensor
import ru.stnkv.SunnyBotKt.MessageCat.Diag.Refer.ReferMain
import ru.stnkv.SunnyBotKt.MessageCat.Diag.SRS.SRS
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.EFI.EFI
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.ElectricMain
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses.DorestInside
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses.DorestOutside
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses.DorestRele
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses.FusesInfo
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses.RestInside
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses.RestOutside
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Fuses.RestRele
import ru.stnkv.SunnyBotKt.MessageCat.Elctric.Lams.Lamps
import ru.stnkv.SunnyBotKt.MessageCat.Manual.Manual
import ru.stnkv.SunnyBotKt.MessageCat.Other.Offense
import ru.stnkv.SunnyBotKt.MessageCat.StartMessage.StartMessage
import ru.stnkv.SunnyBotKt.MessageCat.TO.AT.AT
import ru.stnkv.SunnyBotKt.MessageCat.TO.Brake.Brake
import ru.stnkv.SunnyBotKt.MessageCat.TO.Conditioner.Conditioner
import ru.stnkv.SunnyBotKt.MessageCat.TO.Cooling.Cooling
import ru.stnkv.SunnyBotKt.MessageCat.TO.Engine.Engine
import ru.stnkv.SunnyBotKt.MessageCat.TO.Fuel.Fuel
import ru.stnkv.SunnyBotKt.MessageCat.TO.TOMain
import ru.stnkv.SunnyBotKt.MessageCat.Upgrade.BodyOptic
import ru.stnkv.SunnyBotKt.MessageCat.Upgrade.ElectricDop
import ru.stnkv.SunnyBotKt.MessageCat.Upgrade.OtherDop
import ru.stnkv.SunnyBotKt.MessageCat.Upgrade.SalonDop
import ru.stnkv.SunnyBotKt.MessageCat.Upgrade.UpgradeMain


@Component
class SunnyBot(
    @Value("\${telegram.token}")
    val token: String = "",

    @Value("\${telegram.name")
    val botName: String = "",
) : TelegramLongPollingBot(token) {

    override fun getBotUsername(): String? = botName

    @OptIn(DelicateCoroutinesApi::class)
    override fun onUpdateReceived(update: Update) {
        CoroutineScope(Dispatchers.IO).launch {
            updateHandler(update)
        }
        CoroutineScope(Dispatchers.IO).launch {
            val dataBaseUsers = DataBaseUsers()
            dataBaseUsers.dataBaseHelper(update)
        }
    }

    // Основная логика
    private suspend fun updateHandler(update: Update) {

        //Обработка сообщений
        if (update.hasMessage() && update.message.hasText()) {
            val userID = update.message.chatId.toString()
            val text = update.message.text

            //Общие сообщения
            if (text == "/bot" || text == "/start" || text == "/bot@nissan_sunny_bot") {
                val response = StartMessage()
                sendPhoto(response.getNewMessage(userID))
            }
            //Сообщения вне чатов
            if (!userID.contains("-")) {
                if (text.uppercase().contains("ЧАТ")) {
                    val response = ChatNSK()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("ПРОЕКТ")) {
                    val response = About()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("ЭБУ")) {
                    val response = EFI()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("УСТРОЙСТВА")) {
                    val response = DeviceMain()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("ПРОГРАММЫ")) {
                    val response = ProgramsMain()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("ОШИБКИ")) {
                    val response = DTCMain()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("АКПП")) {
                    val response = ATDiag()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("ABS")) {
                    val response = ABSDiag()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("SRS")) {
                    val response = SRS()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("ТО")) {
                    val response = TOMain()
                    sendPhoto(response.getNewMessage(userID))
                }
                else if (text.uppercase().contains("ЛАМПЫ")) {
                    val response = Lamps()
                    sendPhoto(response.getNewMessage(userID))
                }

            }


            //Сообщения в чатах и личке
            if (text.uppercase().contains("ДМРВ") || text.uppercase().contains("MAF")) {
                val response = MAF()
                sendPhoto(response.getNewMessage(userID))
            } else if (text.uppercase().contains("ELM") || text.uppercase().contains("ЕЛМ")) {
                val response = ELM()
                sendPhoto(response.getNewMessage(userID))
            } else if (text.uppercase().contains("МАНУАЛ") || text.uppercase().contains("MANUAL")) {
                val response = Manual()
                sendPhoto(response.getNewMessage(userID))
            } else if (text.uppercase().contains("ПРЕДОХРАНИТЕЛИ") || text.uppercase().contains("ПРЕДОХРАНИТЕЛЬ")) {
                val response = FusesInfo()
                sendPhoto(response.getNewMessage(userID))
            } else if (text.uppercase().contains("ОВЕРДРАЙВ")
                || text.uppercase().contains("OVERDRIVE") || text.uppercase().contains("O/D")) {
                val response = ATDiag()
                sendPhoto(response.getNewMessage(userID))
            } else if (text.uppercase().contains("КАКАЯ ЛАМПА") || text.uppercase().contains("КАКАЯ ЛАМПОЧКА")
                || text.uppercase().contains("КАКИЕ ЛАМПЫ") || text.uppercase().contains("КАКИЕ ЛАМПОЧКИ")) {
                val response = Lamps()
                sendPhoto(response.getNewMessage(userID))
            } else if (text.uppercase().contains("ИДИ НАХУЙ")) {
                val response = Offense()
                sendPhoto(response.getNewMessage(userID))
            }


        }
        //Приветствие нового участника группы
        if (update.hasMessage() && update.message.newChatMembers != null && update.message.chatId.toString() == "-1002489403096") {
            val newChatMember = update.message?.newChatMembers
            if (newChatMember != null) {
                for (member in newChatMember) {
                    val response = Greeting()
                    sendPhoto(response.getGreeting("-1002489403096", member.userName))

                }
            }
        }
        //Обработка колбэков
        if (update.hasCallbackQuery()) {
            val callback = update.callbackQuery.data
            val userID = update.callbackQuery.message.chatId.toString()
            val messageID = update.callbackQuery.message.messageId

            when (callback) {
                "MAIN_MENU" -> {
                    val response = StartMessage()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "MAIN_MENU_BACK" -> {
                    val response = StartMessage()
                    editCaption(response.getEditCaption(userID, messageID))
                }

                "COMPUTER_DIAGNOSTIC_MAIN" -> {
                    val response = MainDiag()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "COMPUTER_DIAGNOSTICS_BACK" -> {
                    val response = MainDiag()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "ABS_DIAGNOSTICS_INFO" -> {
                    val response = ABSDiag()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "ABS_ERRORS" -> {
                    val response = ABSErrors()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "AT_DIAGNOSTICS_INFO" -> {
                    val response = ATDiag()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "DECODING_ERRORS_INFO" -> {
                    val response = DTCMain()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0100_INFO" -> {
                    val response = D0100()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0113_INFO" -> {
                    val response = D0113()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0115_INFO" -> {
                    val response = D0115()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0130_INFO" -> {
                    val response = D0130()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0325_INFO" -> {
                    val response = D0325()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0335_INFO" -> {
                    val response = D0335()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0340_INFO" -> {
                    val response = D0340()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0400_INFO" -> {
                    val response = D0400()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0500_INFO" -> {
                    val response = D0500()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P0600_INFO" -> {
                    val response = D0600()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "P1217_INFO" -> {
                    val response = D1217()
                    editCaption(response.getEditCaption(userID, messageID))
                }"P1320_INFO" -> {
                val response = D1320()
                editCaption(response.getEditCaption(userID, messageID))
                }
                "DIAGNOSTIC_DEVICES_INFO" -> {
                    val response = DeviceMain()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "ELM327_INFO" -> {
                    val response = ELM()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "BACK_TO_DIAGNOSTIC_DEVICES" -> {
                    val response = DeviceMain()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "NISSAN3LINE_INFO" -> {
                    val response = NISSAN3LINE()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "VAGCOMKKL_INFO" -> {
                    val response = VAGCOM()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "MANUAL_DIAGNOSTIC_INFO" -> {
                    val response = ManualDiag()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "DIAGNOSTICS_PROGRAMS_INFO" -> {
                    val response = ProgramsMain()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "BACK_TO_DIAGNOSTIC_PROGRAMS" -> {
                    val response = ProgramsMain()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "CAR_SCANNER_INFO" -> {
                    val response = CarScanner()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "NISSAN_ECONTOOL_INFO" -> {
                    val response = Econ()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TECU3_INFO" -> {
                    val response = TECU3()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "REFERENCES_INFO" -> {
                    val response = ReferMain()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "BACK_TO_REFERENCES" -> {
                    val response = ReferMain()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "MAF_SENSOR_REFERENCE" -> {
                    val response = MAF()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "CO_SENSOR_REFERENCE" -> {
                    val response = OxySensor()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "OTHER_REFERENCE" -> {
                    val response = Other()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "SRS_INFO" -> {
                    val response = SRS()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_MAIN" -> {
                    val response = TOMain()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_Engine" -> {
                    val response = Engine()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_AT" -> {
                    val response = AT()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_FUEL_SYSTEM" -> {
                    val response = Fuel()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_COOLING_SYSTEM" -> {
                    val response = Cooling()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_CONDITION_SYSTEM" -> {
                    val response = Conditioner()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_BRAKE_SYSTEM" -> {
                    val response = Brake()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "TO_OTHER" -> {
                    val response = ru.stnkv.SunnyBotKt.MessageCat.TO.Other.Other()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "ELECTRIC_MAIN" -> {
                    val response = ElectricMain()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "ELECTRIC_MAIN_BACK" -> {
                    val response = ElectricMain()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "EFI_INFO" -> {
                    val response = EFI()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "FUSES_INFO" -> {
                    val response = FusesInfo()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "FUSES_INFO_BACK" -> {
                    val response = FusesInfo()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "DOREST_FUSES_BLOCK_SALOON" -> {
                    val response = DorestInside()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "DOREST_FUSES_BLOCK_OUTSIDE" -> {
                    val response = DorestOutside()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "DOREST_OUTSIDE_2" -> {
                    val response = DorestRele()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "REST_FUSES_BLOCK_SALOON" -> {
                    val response = RestInside()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "REST_FUSES_BLOCK_OUTSIDE" -> {
                    val response = RestOutside()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "REST_OUTSIDE_2" -> {
                    val response = RestRele()
                    editPhoto(response.getEditPhoto(userID, messageID))
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "LAMPS_INFO" -> {
                    val response = Lamps()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "MANUAL_MAIN" -> {
                    val response = Manual()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "IMPROVEMENTS_MAIN" -> {
                    val response = UpgradeMain()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "BODY_OPTIC_DOP" -> {
                    val response = BodyOptic()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "ELECTRIC_DOP" -> {
                    val response = ElectricDop()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "SALOON_DOP" -> {
                    val response = SalonDop()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "OTHER_DOP" -> {
                    val response = OtherDop()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "NOVOSIBIRSK_CHAT" -> {
                    val response = ChatNSK()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "ABOUT_MAIN" -> {
                    val response = About()
                    editCaption(response.getEditCaption(userID, messageID))
                }
                "KEY_WORDS" -> {
                    val response = KeyWordsList()
                    editCaption(response.getEditCaption(userID, messageID))
                }
            }
        }
    }

    private fun sendPhoto(message: SendPhoto) {
        executeAsync(message)
    }

    private fun editCaption(message: EditMessageCaption) {
        executeAsync(message)
    }

    private fun editPhoto(message: EditMessageMedia) {
        executeAsync(message)
    }
}