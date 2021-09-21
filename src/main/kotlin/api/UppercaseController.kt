package api

import api.ApiUtils.setBadRequest
import io.javalin.http.Context
import java.util.*

object UppercaseController {
    fun toUppercase(ctx: Context) {
        val word = ctx.pathParam("word")

        if (word.toIntOrNull() == null) {
            ctx.result(word.uppercase(Locale.getDefault()))
            return
        }

        ctx.setBadRequest("You must provide a string!")
    }

}