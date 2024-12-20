package pemobile.praktikum.projectujian.model

data class SpecialDeal(
    val id: Int,
    val title: String,
    val price: Int,
    val slashPrice: String,
    val imageRes: Int,
    val category: String
)