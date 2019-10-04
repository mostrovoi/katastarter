import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test
import org.mockito.Mockito

class WardRobeTest {

    @Test
    fun should_return_all_valid_drawers() {
        val combinationMock = Mockito.mock(Combination::class.java)
        val emailSender = Mockito.mock(EmailSender::class.java)

        val potato = PotatoBasket(total = 0)
        Mockito.`when`(combinationMock.combine()).thenReturn(3);
        val wardRobe = WardRobe(emailSender = emailSender, combination = combinationMock, potato = potato)
        wardRobe.execute()
        assertThat(potato.getPotatoes()).isEqualTo(3)
    }
}