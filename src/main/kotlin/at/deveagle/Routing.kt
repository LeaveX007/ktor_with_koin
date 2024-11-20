package at.deveagle

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject
import kotlin.getValue

fun Application.configureRouting() {
    val helloController by inject<HelloController>()
    routing {
        get("{...}") {
            call.respond(
                HttpStatusCode.NotFound,
                "Routingpfad nicht gefunden!"
            )
        }
        get("/{name}") {
            val nameParam = call.parameters["name"]
            if (nameParam != null) {
                call.respondText(
                    helloController.handleRequest(nameParam)
                )
            }
        }
    }
}