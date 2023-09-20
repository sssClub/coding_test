import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val gift = PriorityQueue<Int>(reverseOrder())

    repeat(n) {
        val a = br.readLine().split(" ")

        when (a[0]) {
            "0" -> {
                val largestGift = gift.poll()
                println(largestGift ?: -1)
            }

            else -> {
                val values = a.drop(1).mapNotNull { it.toIntOrNull() }
                gift.addAll(values)
            }
        }
    }
}

