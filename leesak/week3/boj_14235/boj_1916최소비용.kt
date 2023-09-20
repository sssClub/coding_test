package esak.leesak.week3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Comparator
import java.util.PriorityQueue


private val br = BufferedReader(InputStreamReader(System.`in`))
val INF = 1000000000

fun main() {

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val graph = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distance = MutableList(n + 1) { INF }

    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    repeat(m) {
        val (start, destination, cost) = br.readLine().split(" ").map { it.toInt() }
        graph[start].add(Pair(destination, cost))
    }

    val (startCity, destinationCity) = br.readLine().split(" ").map { it.toInt() }
    distance[startCity] = 0
    queue.add(Pair(startCity, 0))

    while (queue.isNotEmpty()) {
        println("$queue")
        val (city, lastCost) = queue.poll()
        println("$queue")
        if (distance[city] < lastCost) continue

        for ((cityIdx, nextCost) in graph[city]) {
            val resultCost = lastCost + nextCost

            if (resultCost < distance[cityIdx]) {
                distance[cityIdx] = resultCost
                queue.add(Pair(cityIdx, resultCost))
            }
        }
    }
    println(distance[destinationCity])
}


data class Edgd(
        val int: Int,
        val cost:Int
):Comparator<Int> {
    override fun compare(o1: Int, o2: Int): Int {
        return o1 - o2
    }
}
