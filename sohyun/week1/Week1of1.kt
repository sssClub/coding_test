import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Week1of1 {
}

var graph = arrayOf<IntArray>()
var visited = booleanArrayOf()


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, v) = this.readLine().split(" ").map { it.toInt() }
    graph = Array(n) { IntArray(n) }
    visited = BooleanArray(n)

    repeat(m) {
        val (n1, n2) = this.readLine().split(" ").map { it.toInt() }
        graph[n1 - 1][n2 - 1] = 1
        graph[n2 - 1][n1 - 1] = 1
    }
    visited.fill(false)
    println(dfs(n, v))
    visited.fill(false)
    println(bfs(n, v-1))

}

fun dfs(n: Int, v: Int): String {
    val sb = StringBuilder()
    sb.append("$v ")

    visited[v - 1] = true

    for (i in 0 until n) if (graph[v - 1][i] == 1 && !visited[i]) sb.append(dfs(n, i + 1))

    return sb.toString()
}

fun bfs(n: Int, v: Int): String {
    val sb = StringBuilder()
    val list = LinkedList<Int>()

    list.add(v)
    visited[v] = true
    sb.append("${v+1} ")

    while (list.isNotEmpty()) {
        val nod = list.poll()

        for (i in 0 until n){
            if (graph[nod][i] == 1 && !visited[i]) {
                list.add(i)
                visited[i] = true
                sb.append("${i + 1} ")
            }
        }

    }

    return sb.toString()
}

