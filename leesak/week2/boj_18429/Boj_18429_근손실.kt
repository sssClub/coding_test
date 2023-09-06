package esak.leesak.week2.boj_18429

import java.io.BufferedReader
import java.io.InputStreamReader


private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var visited: MutableList<Boolean>
private val graph = mutableListOf<Int>()
private lateinit var plus: MutableList<Int>
var answer = 0


fun main() {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    plus = br.readLine().split(" ").map { it.toInt() } as MutableList<Int>
    visited = MutableList(n) { false }
    dfs(n, k, 500)
    println(answer)
}


fun dfs(n: Int, k: Int, weight: Int) {
    if (weight < 500) return
    if (n == graph.size) {
        answer++
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            val recentWeight = weight + plus[i] - k
            visited[i] = true
            graph.add(i)
            dfs(n, k, recentWeight)
            visited[i] = false
            graph.removeLast()
        }
    }
}