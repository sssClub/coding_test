package esak.leesak.week1.boj_1012

import java.io.BufferedReader
import java.io.InputStreamReader


private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<Array<Int>>
private val dx = arrayOf(-1, 0, 1, 0)
private val dy = arrayOf(0, -1, 0, 1)

fun main() {
    val t = br.readLine().toInt()

    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }

        graph = Array(m) { Array(n) { 0 } }
        var result = 0
        makeMap(k)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (graph[i][j] == 1) {
//                    dfs(i, j, m, n)
                    bfs(i,j,m,n)
                    result++
                }
            }
        }
        println(result)
    }

}

private fun makeMap(k: Int) {
    repeat(k) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x][y] = 1
    }
}

private fun dfs(x: Int, y: Int, m: Int, n: Int) {
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0 until m && ny in 0 until n && graph[nx][ny] == 1) {
                graph[nx][ny] = 0
                dfs(nx, ny, m, n)
        }
    }
}

private fun bfs(x: Int, y: Int, m: Int, n: Int) {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(Pair(x, y))
    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until m && ny in 0 until n && graph[nx][ny]==1 ) {
                graph[nx][ny]=0
                queue.add(Pair(nx,ny))
            }
        }
    }
}