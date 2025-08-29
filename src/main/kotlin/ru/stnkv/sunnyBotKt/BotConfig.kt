package ru.stnkv.sunnyBotKt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import java.util.concurrent.Executors


@Configuration
class BotConfig {

    @Bean
    fun telegramBotsApi(bot: SunnyBot): TelegramBotsApi {
        return TelegramBotsApi(DefaultBotSession::class.java).apply {
            registerBot(bot)
        }
    }

    @Bean
    fun coroutineScope(): CoroutineScope {
       return CoroutineScope(Executors.newFixedThreadPool(5).asCoroutineDispatcher())
    }
}