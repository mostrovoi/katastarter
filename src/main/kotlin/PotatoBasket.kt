class PotatoBasket(var total: Int) {

    fun addPotato(increment: Int) {
        total=total+increment
    }

    fun getPotatoes() : Int {
        return total
    }
}
