import api.UppercaseController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path

fun main() {
    val app = Javalin.create()
        .start(7001)

    app.get("/") { ctx -> ctx.json(listOf("Hello", "World", "!")) }

    app.routes {
        path("api") {
            path("uppercase/{word}") {
                get(UppercaseController::toUppercase)
            }
        }
    }

}
