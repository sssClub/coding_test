package esak.leesak.week1.boj_16173

import java.io.BufferedReader
import java.io.InputStreamReader

private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<List<Int>>
private lateinit var visited: Array<MutableList<Boolean>>
private val dx = listOf(1, 0)
private val dy = listOf(0, 1)
var answer = "Hing"

/**
 *  최단 경로를 찾는 문제
 *
 * **/
fun main() {
    val map = br.readLine().toInt()

    graph = Array(map) { mutableListOf() }
    visited = Array(map) { MutableList(map) { false } }
    makeMap(map)
    visited[0][0] = true
//    dfs(0, 0, map)
    dfs(0, 0, map)
    if (visited[map - 1][map - 1]) answer = "HaruHaru"
    println(answer)
}

private fun makeMap(map: Int) {
    for (i in 0 until map) {
        graph[i] = br.readLine().split(" ").map { it.toInt() }
    }
}

private fun dfs(x: Int, y: Int, map: Int) {
    for (i in 0 until 2) {
        val nx = x + (dx[i] * graph[x][y])
        val ny = y + (dy[i] * graph[x][y])
        if (nx in 0 until map && ny in 0 until map && !visited[nx][ny]) {
            visited[nx][ny] = true
            dfs(nx, ny, map)
        }
    }
}

private fun bfs(x: Int, y: Int, map: Int) {

    val queue = ArrayDeque<Pair<Int, Int>>()
    visited[x][y] = true
    queue.add(Pair(x, y))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeLast()
        for (i in 0 until 2) {
            val nx = x + (dx[i] * graph[x][y])
            val ny = y + (dy[i] * graph[x][y])
            if (nx in 0 until map && ny in 0 until map && !visited[nx][ny]) {
                visited[nx][ny] = true
                queue.add(Pair(nx, ny))
            }
        }

    }
}