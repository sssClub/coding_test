package esak.leesak.week4

import java.io.BufferedReader
import java.io.InputStreamReader


private val br = BufferedReader(InputStreamReader(System.`in`))
private val graph = mutableListOf<List<Int>>()
private lateinit var graphSum: MutableList<MutableList<Int>>

fun main() {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    repeat(n) {
        val item = br.readLine().split(" ").map { it.toInt() }
        graph.add(item)
    }

    graphSum = MutableList(n + 1) { MutableList(m + 1) { 0 } }

    repeat(n) { n ->
        var sum = 0
        repeat(m) { m ->
            sum += graph[n][m]
            graphSum[n + 1][m + 1] = sum
        }
    }
    repeat(br.readLine().toInt()) {
        val (i, j, x, y) = br.readLine().split(" ").map { it.toInt() }
        var result = 0
        for (index in i..x) {
            result += graphSum[index][y] - graphSum[index][j - 1]
        }
        println(result)
    }
}


/**
 *  1 2 4
 *  8 16 32
 *  1,1 -> 2,3 전체의 값을 더한 게 63
 *  1 3 7
 *  8 24 56
 *  1,1 -> 2,3 첫째줄 합  둘쨰줄 합 7+56
 *  1,2 -> 1,2
 *  7 - 0
 *  56 - 0
 *
 *  7 - 3
 *  56 - 24 3
 *
 *
 * **/