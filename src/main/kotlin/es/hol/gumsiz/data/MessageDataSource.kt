package es.hol.gumsiz.data

import es.hol.gumsiz.data.model.Message

interface MessageDataSource {

    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message)
}