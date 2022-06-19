import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun comissionCount_Maestro() {
        //arrange
        val cart = MAESTRO
        val paymentOfLastMonth = 0
        val currentAmount = 150_000_00

        //act
        val result = comissionCount(
            cartType = cart,
            lastAmount = paymentOfLastMonth,
            amount = currentAmount
        )

        //assert
        assertEquals(902000, result)
    }

    @Test
    fun comissionCount_Mastercard() {
        //arrange
        val cart = MASTERCARD
        val paymentOfLastMonth = 0
        val currentAmount = 50_000_00

        //act
        val result = comissionCount(
            cartType = cart,
            lastAmount = paymentOfLastMonth,
            amount = currentAmount
        )

        //assert
        assertEquals(0, result)
    }

    @Test
    fun comissionCount_Vk() {
        //arrange
        val cart = VK
        val paymentOfLastMonth = 0
        val currentAmount = 15_000_00

        //act
        val result = comissionCount(
            cartType = cart,
            lastAmount = paymentOfLastMonth,
            amount = currentAmount
        )

        //assert
        assertEquals(0, result)
    }


    @Test
    fun comissionCount_Mir() {
        //arrange
        val cart = MIR
        val paymentOfLastMonth = 0
        val currentAmount = 100_00

        //act
        val result = comissionCount(
            cartType = cart,
            lastAmount = paymentOfLastMonth,
            amount = currentAmount
        )

        //assert
        assertEquals(35_00, result)
    }

    @Test
    fun comissionMaestroMastercard_shouldCorrectChoose() {
        //arrange
        val paymentOfLastMonth = 150_000_00
        val currentAmount = 75_000_00

        //act
        val result = comissionMaestroMastercard(
            lastAmount = paymentOfLastMonth,
            amount = currentAmount
        )

        //assert
        assertEquals(452000, result)
    }

    @Test
    fun comissionVisaMir_shouldCorrectChoose() {
        //arrange
        val paymentOfLastMonth = 200_00
        val currentAmount = 75_000_00

        //act
        val result = comissionVisaMir(
            lastAmount = paymentOfLastMonth,
            amount = currentAmount
        )

        //assert
        assertEquals(56250, result)

    }

    @Test
    fun comission_notEqualCard() {
        //arrange
        val cart = "SberPay"
        val paymentOfLastMonth = 200_00
        val currentAmount = 75_000_00

        //act
        val result = comissionCount(
            cartType = cart,
            lastAmount = paymentOfLastMonth,
            amount = currentAmount
        )

        //assert
        assertEquals(0, result)

    }

}