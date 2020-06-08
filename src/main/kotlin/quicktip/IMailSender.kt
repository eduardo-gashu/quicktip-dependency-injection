package quicktip

interface IMailSender {
    fun sendMail (name: String, email: String, message: String)
}