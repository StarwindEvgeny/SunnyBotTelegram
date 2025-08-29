package ru.stnkv.sunnyBotKt


import kotlinx.coroutines.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia
import org.telegram.telegrambots.meta.api.objects.Update
import ru.stnkv.sunnyBotKt.messageCat.aboutProject.About
import ru.stnkv.sunnyBotKt.messageCat.aboutProject.KeyWordsList
import ru.stnkv.sunnyBotKt.messageCat.chatNSK.ChatNSK
import ru.stnkv.sunnyBotKt.messageCat.chatNSK.Greeting
import ru.stnkv.sunnyBotKt.messageCat.diag.absDiag.ABSDiag
import ru.stnkv.sunnyBotKt.messageCat.diag.absDiag.ABSErrors
import ru.stnkv.sunnyBotKt.messageCat.diag.atDiag.ATDiag
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0100
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0113
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0115
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0130
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0325
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0335
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0340
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0400
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0500
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D0600
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D1217
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.D1320
import ru.stnkv.sunnyBotKt.messageCat.diag.dtc.DTCMain
import ru.stnkv.sunnyBotKt.messageCat.diag.device.DeviceMain
import ru.stnkv.sunnyBotKt.messageCat.diag.device.elm.ELM
import ru.stnkv.sunnyBotKt.messageCat.diag.device.manualDiag.ManualDiag
import ru.stnkv.sunnyBotKt.messageCat.diag.device.nissan3line.NISSAN3LINE
import ru.stnkv.sunnyBotKt.messageCat.diag.device.vagCom.VAGCOM
import ru.stnkv.sunnyBotKt.messageCat.diag.MainDiag
import ru.stnkv.sunnyBotKt.messageCat.diag.programs.carScanner.CarScanner
import ru.stnkv.sunnyBotKt.messageCat.diag.programs.econ.Econ
import ru.stnkv.sunnyBotKt.messageCat.diag.programs.ProgramsMain
import ru.stnkv.sunnyBotKt.messageCat.diag.programs.tecu3.TECU3
import ru.stnkv.sunnyBotKt.messageCat.diag.refer.maf.MAF
import ru.stnkv.sunnyBotKt.messageCat.diag.refer.other.Other
import ru.stnkv.sunnyBotKt.messageCat.diag.refer.oxySensor.OxySensor
import ru.stnkv.sunnyBotKt.messageCat.diag.refer.ReferMain
import ru.stnkv.sunnyBotKt.messageCat.diag.srs.SRS
import ru.stnkv.sunnyBotKt.messageCat.electric.efi.EFI
import ru.stnkv.sunnyBotKt.messageCat.electric.ElectricMain
import ru.stnkv.sunnyBotKt.messageCat.electric.fuses.DorestInside
import ru.stnkv.sunnyBotKt.messageCat.electric.fuses.DorestOutside
import ru.stnkv.sunnyBotKt.messageCat.electric.fuses.DorestRele
import ru.stnkv.sunnyBotKt.messageCat.electric.fuses.FusesInfo
import ru.stnkv.sunnyBotKt.messageCat.electric.fuses.RestInside
import ru.stnkv.sunnyBotKt.messageCat.electric.fuses.RestOutside
import ru.stnkv.sunnyBotKt.messageCat.electric.fuses.RestRele
import ru.stnkv.sunnyBotKt.messageCat.electric.lamps.Lamps
import ru.stnkv.sunnyBotKt.messageCat.manual.Manual
import ru.stnkv.sunnyBotKt.messageCat.other.Offense
import ru.stnkv.sunnyBotKt.messageCat.startMessage.StartMessage
import ru.stnkv.sunnyBotKt.messageCat.to.at.AT
import ru.stnkv.sunnyBotKt.messageCat.to.brake.Brake
import ru.stnkv.sunnyBotKt.messageCat.to.conditioner.Conditioner
import ru.stnkv.sunnyBotKt.messageCat.to.cooling.Cooling
import ru.stnkv.sunnyBotKt.messageCat.to.engine.Engine
import ru.stnkv.sunnyBotKt.messageCat.to.fuel.Fuel
import ru.stnkv.sunnyBotKt.messageCat.to.TOMain
import ru.stnkv.sunnyBotKt.messageCat.upgrade.BodyOptic
import ru.stnkv.sunnyBotKt.messageCat.upgrade.ElectricDop
import ru.stnkv.sunnyBotKt.messageCat.upgrade.OtherDop
import ru.stnkv.sunnyBotKt.messageCat.upgrade.SalonDop
import ru.stnkv.sunnyBotKt.messageCat.upgrade.UpgradeMain


@Component
class SunnyBot(
    @Value("\${telegram.token}")
    val token: String = "",

    @Value("\${telegram.name}")
    val botName: String = "",

    val coroutineScope: CoroutineScope

) : TelegramLongPollingBot(token) {

    override fun getBotUsername(): String? = botName

    override fun onUpdateReceived(update: Update) {
        coroutineScope.launch {
            updateHandler(update)
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
                    sendNewMessage(MakeResponse.getNewMessage(
                        userID,
                        StartMessage.IMAGE_DIR,
                        StartMessage.CAPTION,
                        StartMessage.getMenu()
                    ))
                }

                //Сообщения вне чатов и проверка в базе данных
                if (!userID.contains("-")) {

                    if (text.uppercase().contains("ЧАТ")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            StartMessage.IMAGE_DIR,
                            ChatNSK.CAPTION,
                            ChatNSK.getMenu()
                        ))
                    } else if (text.uppercase().contains("ПРОЕКТ")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            StartMessage.IMAGE_DIR,
                            About.CAPTION,
                            About.getMenu()
                        ))
                    } else if (text.uppercase().contains("ЭБУ")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            EFI.IMAGE_DIR,
                            EFI.CAPTION,
                            EFI.getMenu()
                        ))
                    } else if (text.uppercase().contains("УСТРОЙСТВА")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            StartMessage.IMAGE_DIR,
                            DeviceMain.CAPTION,
                            DeviceMain.getMenu()
                        ))
                    } else if (text.uppercase().contains("ПРОГРАММЫ")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            StartMessage.IMAGE_DIR,
                            ProgramsMain.CAPTION,
                            ProgramsMain.getMenu()
                        ))
                    } else if (text.uppercase().contains("ОШИБКИ")) {
                       sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            StartMessage.IMAGE_DIR,
                            DTCMain.CAPTION,
                            DTCMain.getMenu()
                        ))
                    } else if (text.uppercase().contains("АКПП")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            ATDiag.IMAGE_DIR,
                            ATDiag.CAPTION,
                            ATDiag.getMenu()
                        ))
                    } else if (text.uppercase().contains("ABS")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            ABSDiag.IMAGE_DIR,
                            ABSDiag.CAPTION,
                            ABSDiag.getMenu()
                        ))
                    } else if (text.uppercase().contains("SRS")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            SRS.IMAGE_DIR,
                            SRS.CAPTION,
                            SRS.getMenu()
                        ))
                    } else if (text.uppercase().contains("ТО")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            StartMessage.IMAGE_DIR,
                            TOMain.CAPTION,
                            TOMain.getMenu()
                        ))
                    } else if (text.uppercase().contains("ЛАМПЫ")) {
                        sendNewMessage(MakeResponse.getNewMessage(
                            userID,
                            StartMessage.IMAGE_DIR,
                            Lamps.CAPTION,
                            Lamps.getMenu()
                        ))
                    }

                }


                //Сообщения в чатах и личке
                if (text.uppercase().contains("ДМРВ") || text.uppercase().contains("MAF")) {
                    sendNewMessage(MakeResponse.getNewMessage(
                        userID,
                        MAF.IMAGE_DIR,
                        MAF.CAPTION,
                        MAF.getMenu()
                    ))
                } else if (text.uppercase().contains("ELM") || text.uppercase().contains("ЕЛМ")) {
                    sendNewMessage(MakeResponse.getNewMessage(
                        userID,
                        ELM.IMAGE_DIR,
                        ELM.CAPTION,
                        ELM.getMenu()
                    ))
                } else if (text.uppercase().contains("МАНУАЛ") || text.uppercase().contains("MANUAL")) {
                    sendNewMessage(MakeResponse.getNewMessage(
                        userID,
                        StartMessage.IMAGE_DIR,
                        Manual.CAPTION,
                        Manual.getMenu()
                    ))
                } else if (text.uppercase().contains("ПРЕДОХРАНИТЕЛИ") || text.uppercase().contains("ПРЕДОХРАНИТЕЛЬ")) {
                    sendNewMessage(MakeResponse.getNewMessage(
                        userID,
                        StartMessage.IMAGE_DIR,
                        FusesInfo.CAPTION,
                        FusesInfo.getMenu()
                    ))
                } else if (text.uppercase().contains("ОВЕРДРАЙВ")
                    || text.uppercase().contains("OVERDRIVE") || text.uppercase().contains("O/D")
                ) {
                    sendNewMessage(MakeResponse.getNewMessage(
                        userID,
                        ATDiag.IMAGE_DIR,
                        ATDiag.CAPTION,
                        ATDiag.getMenu()
                    ))
                } else if (text.uppercase().contains("КАКАЯ ЛАМПА") || text.uppercase().contains("КАКАЯ ЛАМПОЧКА")
                    || text.uppercase().contains("КАКИЕ ЛАМПЫ") || text.uppercase().contains("КАКИЕ ЛАМПОЧКИ")
                ) {
                    sendNewMessage(MakeResponse.getNewMessage(
                        userID,
                        StartMessage.IMAGE_DIR,
                        Lamps.CAPTION,
                        Lamps.getMenu()
                    ))
                } else if (text.uppercase().contains("ИДИ НАХУЙ")) {
                    sendNewMessage(Offense.getNewMessage(userID))
                }


            }
            //Приветствие нового участника группы
            if (update.hasMessage() && update.message.newChatMembers != null && update.message.chatId.toString() == "-1002489403096") {
                val newChatMember = update.message?.newChatMembers
                if (newChatMember != null) {
                    for (member in newChatMember) {
                        sendNewMessage(Greeting.getGreeting("-1002489403096", member.userName))
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
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            StartMessage.IMAGE_DIR,
                            StartMessage.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            StartMessage.CAPTION,
                            StartMessage.getMenu()
                        ))
                    }

                    "MAIN_MENU_BACK" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                          userID,
                            messageID,
                            StartMessage.CAPTION,
                            StartMessage.getMenu()
                        ))
                    }

                    "COMPUTER_DIAGNOSTIC_MAIN" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            MainDiag.CAPTION,
                            MainDiag.getMenu()
                        ))
                    }

                    "COMPUTER_DIAGNOSTICS_BACK" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                          userID,
                            messageID,
                            StartMessage.IMAGE_DIR,
                            MainDiag.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            MainDiag.CAPTION,
                            MainDiag.getMenu()
                        ))
                    }

                    "ABS_DIAGNOSTICS_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            ABSDiag.IMAGE_DIR,
                            ABSDiag.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ABSDiag.CAPTION,
                            ABSDiag.getMenu()
                        ))
                    }

                    "ABS_ERRORS" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            ABSErrors.IMAGE_DIR,
                            ABSErrors.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ABSErrors.CAPTION,
                            ABSErrors.getMenu()
                        ))
                    }

                    "AT_DIAGNOSTICS_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            ATDiag.IMAGE_DIR,
                            ATDiag.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ATDiag.CAPTION,
                            ATDiag.getMenu()
                        ))
                    }

                    "DECODING_ERRORS_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            DTCMain.CAPTION,
                            DTCMain.getMenu()
                        ))
                    }

                    "P0100_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0100.CAPTION,
                            D0100.getMenu()
                        ))
                    }

                    "P0113_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0113.CAPTION,
                            D0113.getMenu()
                        ))
                    }

                    "P0115_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0115.CAPTION,
                            D0115.getMenu()
                        ))
                    }

                    "P0130_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0130.CAPTION,
                            D0130.getMenu()
                        ))
                    }

                    "P0325_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0325.CAPTION,
                            D0325.getMenu()
                        ))
                    }

                    "P0335_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0335.CAPTION,
                            D0335.getMenu()
                        ))
                    }

                    "P0340_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0340.CAPTION,
                            D0340.getMenu()
                        ))
                    }

                    "P0400_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0400.CAPTION,
                            D0400.getMenu()
                        ))
                    }

                    "P0500_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0500.CAPTION,
                            D0500.getMenu()
                        ))
                    }

                    "P0600_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D0600.CAPTION,
                            D0600.getMenu()
                        ))
                    }

                    "P1217_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D1217.CAPTION,
                            D1217.getMenu()
                        ))
                    }

                    "P1320_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            D1320.CAPTION,
                            D1320.getMenu()
                        ))
                    }

                    "DIAGNOSTIC_DEVICES_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            DeviceMain.CAPTION,
                            DeviceMain.getMenu()
                        ))
                    }

                    "ELM327_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            ELM.IMAGE_DIR,
                            ELM.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ELM.CAPTION,
                            ELM.getMenu()
                        ))
                    }

                    "BACK_TO_DIAGNOSTIC_DEVICES" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            StartMessage.IMAGE_DIR,
                            DeviceMain.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            DeviceMain.CAPTION,
                            DeviceMain.getMenu()
                        ))
                    }

                    "NISSAN3LINE_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            NISSAN3LINE.IMAGE_DIR,
                            NISSAN3LINE.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            NISSAN3LINE.CAPTION,
                            NISSAN3LINE.getMenu()
                        ))
                    }

                    "VAGCOMKKL_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            VAGCOM.IMAGE_DIR,
                            VAGCOM.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            VAGCOM.CAPTION,
                            VAGCOM.getMenu()
                        ))
                    }

                    "MANUAL_DIAGNOSTIC_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            ManualDiag.IMAGE_DIR,
                            ManualDiag.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ManualDiag.CAPTION,
                            ManualDiag.getMenu()
                        ))
                    }

                    "DIAGNOSTICS_PROGRAMS_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ProgramsMain.CAPTION,
                            ProgramsMain.getMenu()
                        ))
                    }

                    "BACK_TO_DIAGNOSTIC_PROGRAMS" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            StartMessage.IMAGE_DIR,
                            ProgramsMain.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ProgramsMain.CAPTION,
                            ProgramsMain.getMenu()
                        ))
                    }

                    "CAR_SCANNER_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            CarScanner.IMAGE_DIR,
                            CarScanner.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            CarScanner.CAPTION,
                            CarScanner.getMenu()
                        ))
                    }

                    "NISSAN_ECONTOOL_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            Econ.IMAGE_DIR,
                            Econ.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Econ.CAPTION,
                            Econ.getMenu()
                        ))
                    }

                    "TECU3_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            TECU3.IMAGE_DIR,
                            TECU3.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            TECU3.CAPTION,
                            TECU3.getMenu()
                        ))
                    }

                    "REFERENCES_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ReferMain.CAPTION,
                            ReferMain.getMenu()
                        ))
                    }

                    "BACK_TO_REFERENCES" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            StartMessage.IMAGE_DIR,
                            ReferMain.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ReferMain.CAPTION,
                            ReferMain.getMenu()
                        ))
                    }

                    "MAF_SENSOR_REFERENCE" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            MAF.IMAGE_DIR,
                            MAF.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            MAF.CAPTION,
                            MAF.getMenu()
                        ))
                    }

                    "CO_SENSOR_REFERENCE" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            OxySensor.IMAGE_DIR,
                            OxySensor.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            OxySensor.CAPTION,
                            OxySensor.getMenu()
                        ))
                    }

                    "OTHER_REFERENCE" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Other.CAPTION,
                            Other.getMenu()
                        ))
                    }

                    "SRS_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            SRS.IMAGE_DIR,
                            SRS.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            SRS.CAPTION,
                            SRS.getMenu()
                        ))
                    }

                    "TO_MAIN" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            TOMain.CAPTION,
                            TOMain.getMenu()
                        ))
                    }

                    "TO_Engine" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Engine.CAPTION,
                            Engine.getMenu()
                        ))
                    }

                    "TO_AT" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            AT.CAPTION,
                            AT.getMenu()
                        ))
                    }

                    "TO_FUEL_SYSTEM" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Fuel.CAPTION,
                            Fuel.getMenu()
                        ))
                    }

                    "TO_COOLING_SYSTEM" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Cooling.CAPTION,
                            Cooling.getMenu()
                        ))
                    }

                    "TO_CONDITION_SYSTEM" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Conditioner.CAPTION,
                            Conditioner.getMenu()
                        ))
                    }

                    "TO_BRAKE_SYSTEM" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Brake.CAPTION,
                            Brake.getMenu()
                        ))
                    }

                    "TO_OTHER" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ru.stnkv.sunnyBotKt.messageCat.to.other.Other.CAPTION,
                            ru.stnkv.sunnyBotKt.messageCat.to.other.Other.getMenu()
                        ))
                    }

                    "ELECTRIC_MAIN" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ElectricMain.CAPTION,
                            ElectricMain.getMenu()
                        ))
                    }

                    "ELECTRIC_MAIN_BACK" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            StartMessage.IMAGE_DIR,
                            ElectricMain.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ElectricMain.CAPTION,
                            ElectricMain.getMenu()
                        ))
                    }

                    "EFI_INFO" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            EFI.IMAGE_DIR,
                            EFI.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            EFI.CAPTION,
                            EFI.getMenu()
                        ))
                    }

                    "FUSES_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            FusesInfo.CAPTION,
                            FusesInfo.getMenu()
                        ))
                    }

                    "FUSES_INFO_BACK" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            StartMessage.IMAGE_DIR,
                            FusesInfo.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            FusesInfo.CAPTION,
                            FusesInfo.getMenu()
                        ))
                    }

                    "DOREST_FUSES_BLOCK_SALOON" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            DorestInside.IMAGE_DIR,
                            DorestInside.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            DorestInside.CAPTION,
                            DorestInside.getMenu()
                        ))
                    }

                    "DOREST_FUSES_BLOCK_OUTSIDE" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            DorestOutside.IMAGE_DIR,
                            DorestOutside.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            DorestOutside.CAPTION,
                            DorestOutside.getMenu()
                        ))
                    }

                    "DOREST_OUTSIDE_2" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            DorestRele.IMAGE_DIR,
                            DorestRele.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            DorestRele.CAPTION,
                            DorestRele.getMenu()
                        ))
                    }

                    "REST_FUSES_BLOCK_SALOON" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            RestInside.IMAGE_DIR,
                            RestInside.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            RestInside.CAPTION,
                            RestInside.getMenu()
                        ))
                    }

                    "REST_FUSES_BLOCK_OUTSIDE" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            RestOutside.IMAGE_DIR,
                            RestOutside.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            RestOutside.CAPTION,
                            RestOutside.getMenu()
                        ))
                    }

                    "REST_OUTSIDE_2" -> {
                        sendEditPhoto(MakeResponse.getEditPhoto(
                            userID,
                            messageID,
                            RestRele.IMAGE_DIR,
                            RestRele.getMenu()
                        ))

                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            RestRele.CAPTION,
                            RestRele.getMenu()
                        ))
                    }

                    "LAMPS_INFO" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Lamps.CAPTION,
                            Lamps.getMenu()
                        ))
                    }

                    "MANUAL_MAIN" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            Manual.CAPTION,
                            Manual.getMenu()
                        ))
                    }

                    "IMPROVEMENTS_MAIN" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            UpgradeMain.CAPTION,
                            UpgradeMain.getMenu()
                        ))
                    }

                    "BODY_OPTIC_DOP" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            BodyOptic.CAPTION,
                            BodyOptic.getMenu()
                        ))
                    }

                    "ELECTRIC_DOP" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ElectricDop.CAPTION,
                            ElectricDop.getMenu()
                        ))
                    }

                    "SALOON_DOP" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            SalonDop.CAPTION,
                            SalonDop.getMenu()
                        ))
                    }

                    "OTHER_DOP" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            OtherDop.CAPTION,
                            OtherDop.getMenu()
                        ))
                    }

                    "NOVOSIBIRSK_CHAT" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            ChatNSK.CAPTION,
                            ChatNSK.getMenu()
                        ))
                    }

                    "ABOUT_MAIN" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            About.CAPTION,
                            About.getMenu()
                        ))
                    }

                    "KEY_WORDS" -> {
                        sendEditCaption(MakeResponse.getEditCaption(
                            userID,
                            messageID,
                            KeyWordsList.CAPTION,
                            KeyWordsList.getMenu()
                        ))
                    }
                }
            }

    }

    private fun sendNewMessage(message: SendPhoto) {
        try {
            execute(message)
        } catch (e: Exception) {
            println("Ошибка в отправке нового сообщения")
        }
    }

    private fun sendEditCaption(message: EditMessageCaption) {
        try {
            execute(message)
        } catch (e: Exception) {
            println("Ошибка в изменении существующего сообщения")
        }
    }

    private fun sendEditPhoto(message: EditMessageMedia) {
        try {
            execute(message)
        } catch (e: Exception) {
            println("Ошибка в изменении фото сущестующего сообщения")
        }
    }
}