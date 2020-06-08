package quicktip

class MailSenderImplementation: IMailSender {
    private val mailSender = MailSenderExternalLib()
    override fun sendMail(name: String, email: String, message: String) {
        mailSender.sendMail(name, email, message)
    }
}