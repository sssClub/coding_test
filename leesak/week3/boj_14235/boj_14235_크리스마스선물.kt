package esak.leesak.week3.boj_14235

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    //컬렉션에 Comparator 연산자
    //오름 차순으로 만들고 싶다면 아무것도 안하거나 Comparator.naturalOrder()
    val q = PriorityQueue<Int>(Collections.reverseOrder())
    val n = br.readLine().toInt()
    repeat(n) {
        val p = br.readLine()
        when (p) {
            "0" -> {
                if (q.isEmpty()) println(-1)
                else println(q.poll())
            }
            else -> {
                val items = p.split(" ").drop(1)
                for (item in items)
                        item.toIntOrNull()?.let { q.add(it) }
            }
        }
    }
}