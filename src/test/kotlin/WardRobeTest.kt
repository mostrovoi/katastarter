import assertk.assertThat
import assertk.assertions.isEqualTo
import com.bpodgursky.jbool_expressions.Expression
import com.bpodgursky.jbool_expressions.parsers.ExprParser
import com.bpodgursky.jbool_expressions.rules.RuleSet
import org.junit.Test
import org.mariuszgromada.math.mxparser.Argument
import org.mariuszgromada.math.mxparser.License
import org.mockito.Mockito
import java.util.*
import kotlin.system.measureTimeMillis


class WardRobeTest {


    @Test
    fun shouldReturnTrueForJbool() {
        val random = Random()

        val timeExecuted = measureTimeMillis {
            val originalExpression: Expression<String> = ExprParser.parse("((r1 | r2) & (r3 | r4))")
            repeat(1_000_000) {
                val randomValue = random.nextBoolean()
                val firstResult =
                    RuleSet.assign(
                        originalExpression,
                        mapOf("r1" to randomValue, "r2" to true, "r3" to randomValue, "r4" to false)
                    )
                println(firstResult)
            }
        }
        println("Time executed for 1_000_000 is...: $timeExecuted millis")
    }

    @Test
    fun shouldReturnTrueformxParser() {
        License.iConfirmNonCommercialUse("oscar")
        val timeExecuted = measureTimeMillis {
                repeat(1_00_000) {
                    val value = (0..1).random().toDouble()
                    val arg1 = Argument("A")
                    arg1.argumentValue = value
                    val arg2 = Argument("B")
                    arg2.argumentValue = 1.0
                    val arg3 = Argument("Z")
                    arg3.argumentValue = value
                    val arg4 = Argument("D")
                    arg4.argumentValue = 0.0
                    val otherExpression =
                        org.mariuszgromada.math.mxparser.Expression("(A || B) && (Z || D)", arg1, arg2, arg3, arg4)
                    otherExpression.calculate()
                }
        }
        println("Time executed for 1_000_000 is...: $timeExecuted")
    }
}