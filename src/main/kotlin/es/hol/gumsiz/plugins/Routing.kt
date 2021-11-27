package es.hol.gumsiz.plugins

import es.hol.gumsiz.chatroom.RoomController
import es.hol.gumsiz.routes.chatSocket
import es.hol.gumsiz.routes.getAllMessages
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing){
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
