package pemobile.praktikum.projectujian.data

import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.model.SpecialDeal

object ProductProvider {

    fun getProducts(): List<SpecialDeal> {
        return listOf(
            // Paket
            SpecialDeal(
                id = 1,
                title = "Paket Sop",
                price = 18000,
                slashPrice = "Rp 21,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),
            SpecialDeal(
                id = 2,
                title = "Paket Daging",
                price = 35000,
                slashPrice = "Rp 40,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),
            SpecialDeal(
                id = 3,
                title = "Paket Nasi Goreng",
                price = 22000,
                slashPrice = "Rp 25,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),
            SpecialDeal(
                id = 4,
                title = "Paket Ayam Bakar",
                price = 28000,
                slashPrice = "Rp 32,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),
            SpecialDeal(
                id = 5,
                title = "Paket Salad",
                price = 15000,
                slashPrice = "Rp 18,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),
            SpecialDeal(
                id = 6,
                title = "Paket Ikan Bakar",
                price = 40000,
                slashPrice = "Rp 45,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),
            SpecialDeal(
                id = 7,
                title = "Paket Sate",
                price = 25000,
                slashPrice = "Rp 28,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),
            SpecialDeal(
                id = 8,
                title = "Paket Gudeg",
                price = 30000,
                slashPrice = "Rp 35,000",
                imageRes = R.drawable.paket_lima,
                category = "Paket"
            ),

            // Buah
            SpecialDeal(
                id = 9,
                title = "Apel",
                price = 10000,
                slashPrice = "Rp 12,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),
            SpecialDeal(
                id = 10,
                title = "Jeruk",
                price = 15000,
                slashPrice = "Rp 18,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),
            SpecialDeal(
                id = 11,
                title = "Mangga",
                price = 20000,
                slashPrice = "Rp 25,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),
            SpecialDeal(
                id = 12,
                title = "Pisang",
                price = 8000,
                slashPrice = "Rp 10,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),
            SpecialDeal(
                id = 13,
                title = "Durian",
                price = 50000,
                slashPrice = "Rp 60,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),
            SpecialDeal(
                id = 14,
                title = "Strawberry",
                price = 30000,
                slashPrice = "Rp 35,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),
            SpecialDeal(
                id = 15,
                title = "Melon",
                price = 12000,
                slashPrice = "Rp 15,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),
            SpecialDeal(
                id = 16,
                title = "Pepaya",
                price = 10000,
                slashPrice = "Rp 12,000",
                imageRes = R.drawable.paket_lima,
                category = "Buah"
            ),

            // Sayuran
            SpecialDeal(
                id = 17,
                title = "Bayam",
                price = 5000,
                slashPrice = "Rp 7,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),
            SpecialDeal(
                id = 18,
                title = "Kangkung",
                price = 6000,
                slashPrice = "Rp 8,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),
            SpecialDeal(
                id = 19,
                title = "Wortel",
                price = 8000,
                slashPrice = "Rp 10,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),
            SpecialDeal(
                id = 20,
                title = "Kol",
                price = 7000,
                slashPrice = "Rp 9,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),
            SpecialDeal(
                id = 21,
                title = "Brokoli",
                price = 12000,
                slashPrice = "Rp 15,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),
            SpecialDeal(
                id = 22,
                title = "Tomat",
                price = 9000,
                slashPrice = "Rp 11,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),
            SpecialDeal(
                id = 23,
                title = "Bawang Merah",
                price = 4000,
                slashPrice = "Rp 5,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),
            SpecialDeal(
                id = 24,
                title = "Cabe",
                price = 3000,
                slashPrice = "Rp 4,000",
                imageRes = R.drawable.paket_lima,
                category = "Sayuran"
            ),

            // Rempah
            SpecialDeal(
                id = 25,
                title = "Paket Jahe",
                price = 5000,
                slashPrice = "Rp 6,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            ),
            SpecialDeal(
                id = 26,
                title = "Paket Kunyit",
                price = 4000,
                slashPrice = "Rp 5,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            ),
            SpecialDeal(
                id = 27,
                title = "Paket Lengkuas",
                price = 7000,
                slashPrice = "Rp 8,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            ),
            SpecialDeal(
                id = 28,
                title = "Paket Merica",
                price = 3000,
                slashPrice = "Rp 4,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            ),
            SpecialDeal(
                id = 29,
                title = "Paket Serai",
                price = 6000,
                slashPrice = "Rp 7,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            ),
            SpecialDeal(
                id = 30,
                title = "Paket Cengkeh",
                price = 10000,
                slashPrice = "Rp 12,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            ),
            SpecialDeal(
                id = 31,
                title = "Paket Kencur",
                price = 5000,
                slashPrice = "Rp 6,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            ),
            SpecialDeal(
                id = 32,
                title = "Paket Bangle",
                price = 7000,
                slashPrice = "Rp 8,000",
                imageRes = R.drawable.paket_lima,
                category = "Rempah"
            )
        )
    }
}