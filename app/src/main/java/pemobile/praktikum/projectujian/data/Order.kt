package pemobile.praktikum.projectujian.data

import pemobile.praktikum.projectujian.model.Pesanan

object Order {

    val orders = mutableListOf<Pesanan>()

    fun addItems(orders: List<Pesanan>) {
        this.orders.addAll(orders)
    }
}