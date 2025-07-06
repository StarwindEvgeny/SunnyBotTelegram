package ru.stnkv.SunnyBotKt

import org.springframework.beans.factory.annotation.Value
import org.telegram.telegrambots.meta.api.objects.Update
import java.sql.Connection
import java.sql.DriverManager

class DataBaseUsers {

    @Value("\${database.url}")
    val url = ""
    @Value("\${database.login}")
    val login = ""
    @Value("\${database.password}")
    val password = ""
    @Value("\${database.tableName}")
    val tableName = ""
    @Value("\${database.columnName}")
    val columnName = ""

    fun dataBaseHelper(update: Update) {
        val userID = update.message.chatId.toString()
        val userName: String? = update.message.chat.userName
        val firstName: String? = update.message.chat.firstName

        try {
            val connection: Connection = DriverManager.getConnection(url, login, password)

            checkAndInsertRecord(connection, userID, userName, firstName)

            connection.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }



    }

    private fun checkAndInsertRecord(connection: Connection, userID: String, userName: String?, firstName: String?) {

        // Проверка наличия записи
        var exists = false
        connection.prepareStatement(
            "SELECT COUNT(*) FROM $tableName WHERE $columnName=?"
        ).use { statement ->
            statement.setString(1, userID)
            val resultSet = statement.executeQuery()
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0
            }

        }

        if (!exists) {
            // Запись отсутствует, добавляем новую
            connection.prepareStatement(
                "INSERT INTO $tableName ($columnName, user_name, first_name) VALUES (?, ?, ?)"
            ).use { insertStatement ->
                insertStatement.setString(1, userID)
                insertStatement.setString(2, userName?: "None")
                insertStatement.setString(3, firstName?: "None")
                insertStatement.executeUpdate()
            }
        }
    }

}