const val MAESTRO = "Maestro"
const val MASTERCARD = "MasterCard"
const val VISA = "VISA"
const val MIR = "Мир"
const val VK = "VK Pay"
const val MAXAMOUNT_MAESTRO_MASTERCARD = 75000_00
const val MINAMOUNT_MAESTRO_MASTERCARD = 300_00
const val FIXCOMMISSION_MAESTRO_MASTERCARD = 20_00
const val COMMISSIONPERCENT_MAESTRO_MASTERCARD = 0.06
const val FIXCOMMISSION_VISA_MIR = 35_00
const val COMMISSIONPERCENT_VISA_MIR = 0.0075
const val COMMISSIONPERCENT_VK = 0

fun main() {
    printing(MAESTRO, 0, 1200000_00)
    printing(MASTERCARD, 0, 200_00)
    printing(VISA, 0, 150000_00)
    printing(VK, 15000_00, 75000_00)
}

fun comissionMaestroMastercard(lastAmount: Int, amount: Int): Int {
    val totalAmount = amount + lastAmount
    val comission = when (totalAmount) {
        in MINAMOUNT_MAESTRO_MASTERCARD..MAXAMOUNT_MAESTRO_MASTERCARD ->
            0
        else ->
            (COMMISSIONPERCENT_MAESTRO_MASTERCARD * amount + FIXCOMMISSION_MAESTRO_MASTERCARD).toInt()
    }
    return comission
}

fun comissionVisaMir(lastAmount: Int, amount: Int): Int {
    if (COMMISSIONPERCENT_VISA_MIR * amount <= FIXCOMMISSION_VISA_MIR) {
        return FIXCOMMISSION_VISA_MIR.toInt()
    } else {
        return (COMMISSIONPERCENT_VISA_MIR * amount).toInt()
    }
}

fun comissionCount(cartType: String = VK, lastAmount: Int = 0, amount: Int): Int {
    val comission = when (cartType) {
        MAESTRO, MASTERCARD -> comissionMaestroMastercard(lastAmount, amount)
        VISA, MIR -> comissionVisaMir(lastAmount, amount)
        VK -> COMMISSIONPERCENT_VK * amount
        else -> 0
    }
    return comission
}

fun printing(cartType: String = VK, lastAmount: Int = 0, amount: Int) {
    println("Тип карты: $cartType")
    println("Сумма перевода: $amount")
    println("Комиссия за перевод составит:" + comissionCount(cartType, lastAmount, amount))
    println("********")
}

