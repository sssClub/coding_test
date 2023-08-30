import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {

    val (edges, nodes, start) = reader.readLine().split(" ").map { it.toInt() }
    val graphDfs = Array(edges + 1) { IntArray(edges + 1) }
    val graphBfs = Array(edges + 1) { IntArray(edges + 1) }
    val isVisited = BooleanArray(edges + 1) { false }
    val queue: Queue<Int> = LinkedList()

    repeat(nodes) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        graphDfs[a][b] = 1
        graphDfs[b][a] = 1
        graphBfs[a][b] = 1
        graphBfs[b][a] = 1
    }

    fun dfs(s: Int) {
        print("${s} ")
        isVisited[s] = true

        for (idx in graphDfs[s].indices) {
            if (!isVisited[idx] && graphDfs[s][idx] == 1) {
                graphDfs[s][idx] = 0
                graphDfs[idx][s] = 0
                dfs(idx)
            }
        }
    }

    fun bfs(s: Int) {
        isVisited[s] = false
        queue.add(s)
        var tmp = s
        while (queue.isNotEmpty()) {
            tmp = queue.peek()
            print("${queue.poll()} ")
            for (idx in graphBfs[tmp].indices) {
                if (isVisited[idx] && graphBfs[tmp][idx] == 1) {
                    queue.add(idx)
                    isVisited[idx] = false
                }
            }
        }
    }

    dfs(start)
    println("")
    bfs(start)
}
