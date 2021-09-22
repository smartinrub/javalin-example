package api

import io.javalin.http.Context
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test

class UppercaseControllerTest {

    private val ctx = mockk<Context>(relaxed = true)

    @Test
    fun `GET to to uppercase returns uppercase word for valid word`() {
        // GIVEN
        every { ctx.pathParam("word") } returns "hello"

        // WHEN
        UppercaseController.toUppercase(ctx)

        // THEN
        verify { ctx.result("HELLO") }
    }

    @Test
    fun `GET to to uppercase returns bad request for number`() {
        // GIVEN
        every { ctx.pathParam("word") } returns "123"

        // WHEN
        UppercaseController.toUppercase(ctx)

        // THEN
        verify { ctx.status(400) }
        verify { ctx.json("You must provide a string!") }
    }
}