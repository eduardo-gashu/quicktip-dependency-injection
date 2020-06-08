package quicktip

class Mailer {
    private val mailSender: MailSenderExternalLib = MailSenderExternalLib()

    fun welcome(name: String, email: String): Boolean {
        return try {
            this.mailSender.send(name, email, "Welcome")
            true
        } catch (e:Exception){
            throw Exception("Failed to send Welcome")
            //no projeto, jogar uma exceção coerente com o contexto
            //coloquei essa exception genérica só para simplificar
        }
    }
}
