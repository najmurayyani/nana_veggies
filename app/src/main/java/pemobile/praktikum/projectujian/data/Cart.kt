package pemobile.praktikum.projectujian.data

import pemobile.praktikum.projectujian.model.CartItem

object Cart {

    val cartItems = mutableListOf<CartItem>()

    fun addItem(cartItem: CartItem) {
        cartItems.add(cartItem)
    }

    fun removeItem(cartItem: CartItem) {
        cartItems.remove(cartItem)
    }

    fun updateItemQuantity(cartItem: CartItem, quantity: Int) {
        val index = cartItems.indexOfFirst { it.title == cartItem.title }
        if (index != -1) {
            cartItems[index].quantity = quantity
        }
    }

    fun getTotalPrice(): Int {
        return cartItems.sumOf { it.price * it.quantity }
    }
}