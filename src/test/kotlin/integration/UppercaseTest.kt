package integration

import api.JavalinApp
import kong.unirest.Unirest
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class UppercaseTest {

    private val app = JavalinApp().createApp()

    @BeforeTest
    fun setup() {
        app.start(1234)
    }

    @AfterTest
    fun tearDown() {
        app.stop()
    }

    @Test
    fun `GET to to uppercase returns uppercase word` () {
        // WHEN
        val response = Unirest.get("http://localhost:1234/api/uppercase/hello").asString()

        // THEN
        assertThat(response.status).isEqualTo(200)
        assertThat(response.body).isEqualTo("HELLO")
    }

    @Test
    fun `GET to to uppercase returns bad request when number` () {
        // WHEN
        val response = Unirest.get("http://localhost:1234/api/uppercase/999").asString()

        // THEN
        assertThat(response.status).isEqualTo(400)
        assertThat(response.body).isEqualTo("You must provide a string!")
    }
}