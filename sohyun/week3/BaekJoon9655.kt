import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n % 2 == 1) {
        println("SK")
    } else {
        println("CY")
    }
}


