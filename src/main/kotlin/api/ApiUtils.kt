package api

import io.javalin.http.Context

object ApiUtils {
    fun Context.setBadRequest(message: String) {
        status(400)
        json(message)
    }
}