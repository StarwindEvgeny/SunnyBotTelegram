package ru.stnkv.SunnyBotKt

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


@Configuration
class BotConfig {

    @Bean
    fun telegramBotsApi(bot: SunnyBot): TelegramBotsApi {
        return TelegramBotsApi(DefaultBotSession::class.java).apply {
            registerBot(bot)
        }
    }
}