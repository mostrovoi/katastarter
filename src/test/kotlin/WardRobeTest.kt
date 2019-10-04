import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.internal.runners.model.EachTestNotifier
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

class WardRobeTest {

  //  @Before
   // fun setupAccountData() {
    //  MockitoAnnotations.initMocks(this)
   // }

    @Mock
    lateinit var combinationMock : Combination

    @Mock
    lateinit var emailSender : EmailSender

    @Test
    fun should_return_all_valid_drawers() {

        //val combinationMock = Mockito.mock(Combination::class.java)
        //val emailSender = Mockito.mock(EmailSender::class.java)

        val potato = PotatoBasket(total = 0)
        Mockito.`when`(combinationMock.combine()).thenReturn(3);
        val wardRobe = WardRobe(emailSender = emailSender, combination = combinationMock, potato = potato)
        wardRobe.execute()
        assertThat(potato.getPotatoes()).isEqualTo(3)
    }

}