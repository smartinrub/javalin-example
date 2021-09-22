package api

import api.ApiUtils.setInternalError
import exception.ApiException
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder

class JavalinApp {

    fun createApp(): Javalin {
        val app = Javalin.create()

        app.get("/") { ctx -> ctx.json(listOf("Hello", "World", "!")) }

        app.get("exception") {
            throw ApiException("API error!")
        }

        app.routes {
            ApiBuilder.path("api") {
                ApiBuilder.path("uppercase/{word}") {
                    ApiBuilder.get(UppercaseController::toUppercase)
                }
            }
        }

        // Exception is not thrown
        app.exception(ApiException::class.java) { e, ctx ->
            ctx.setInternalError(e.message.toString())
        }

        return app
    }
}