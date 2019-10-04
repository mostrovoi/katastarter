open class WardRobe(val combination: Combination, val potato: PotatoBasket, val emailSender: EmailSender) {

    fun execute() {
        emailSender.sendEmail()
        val value = combination.combine()
        potato.addPotato(value)
    }

}
