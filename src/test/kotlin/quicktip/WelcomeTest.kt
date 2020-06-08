package quicktip

import org.junit.jupiter.api.Test

class WelcomeTest {
    @Test
    fun `it sends a welcome email` () {
        //setup
        val mailer = Mailer()
        val name = "Nome"
        val email = "email@email.com"

        //execution
        val result = mailer.welcome(name, email)

        //assertion
        assert(result)
    }
}