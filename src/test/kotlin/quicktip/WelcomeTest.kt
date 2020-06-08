package quicktip

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WelcomeTest {
    @Test
    fun `it sends a welcome email` () {
        //setup
        val fakeMailSender = mockk<IMailSender>()
        val mailer = Mailer(fakeMailSender)
        val name = "Nome"
        val email = "email@email.com"
        every { fakeMailSender.sendMail(name,email,"Welcome") } returns println("Fake send")

        //execution
        val result = mailer.welcome(name, email)

        //assertion
        assert(result)
    }
    @Test
    fun `it fails to send a welcome email` () {
        //setup
        val fakeMailSender = mockk<IMailSender>()
        val mailer = Mailer(fakeMailSender)
        val name = "Nome"
        val email = "email@email.com"
        every { fakeMailSender.sendMail(name,email,"Welcome") } throws Exception("ops")

        try {
            mailer.welcome(name, email)
            assertTrue(false)
        } catch (exception: Exception) {
            assert(exception.message == "Failed to send Welcome")
        }
    }
}