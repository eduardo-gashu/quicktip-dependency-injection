package quicktip

import org.junit.jupiter.api.Test

class WelcomeTest {
    @Test
    fun `it sends a welcome email` () {
        //setup
        val fakeMailSender = FakeMailSender()
        val mailer = Mailer(fakeMailSender)
        val name = "Nome"
        val email = "email@email.com"

        //execution
        val result = mailer.welcome(name, email)

        //assertion
        assert(result)
    }
    class FakeMailSender: IMailSender {
        override fun sendMail(name: String, email: String, message: String) {
            println("Fake Mail Sender")
        }
    }
}