package week3.boj_14235

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val n = reader.readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(n) {
        val strings = reader.readLine().split(" ")
        val a = strings[0].toInt()
        if (a == 0) {
            val size = pq.size
            if (size != 0) {
                println(pq.remove())
            } else println(-1)
        } else {
            repeat(a) { idx ->
                pq.add(strings[idx+1].toInt())
            }
        }
    }
}
