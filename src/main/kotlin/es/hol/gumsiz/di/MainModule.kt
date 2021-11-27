package es.hol.gumsiz.di

import es.hol.gumsiz.chatroom.RoomController
import es.hol.gumsiz.data.MessageDataSource
import es.hol.gumsiz.data.MessageDataSourceImpl
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db_yt")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}