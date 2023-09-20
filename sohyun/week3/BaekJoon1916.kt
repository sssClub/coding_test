import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Edge(val to: Int, val cost: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val graph = ArrayList<ArrayList<Edge>>(n)
    repeat(n) {
        graph.add(ArrayList())
    }

    repeat(m) {
        val (from, to, cost) = br.readLine().split(" ").map { it.toInt() }
        graph[from - 1].add(Edge(to - 1, cost))
    }

    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    val minCost = dijkstra(graph, start - 1, end - 1)
    println(minCost)
}

fun dijkstra(graph: ArrayList<ArrayList<Edge>>, start: Int, end: Int): Int {
    val n = graph.size
    val distance = IntArray(n) { Int.MAX_VALUE } //초기값 무한대
    val visited = BooleanArray(n)

    distance[start] = 0

    val queue = PriorityQueue<Int>(compareBy { distance[it] })
    queue.add(start)

    while (queue.isNotEmpty()) {
        val city = queue.poll()

        if (visited[city]) continue
        visited[city] = true

        for (edge in graph[city]) {
            val to = edge.to
            val cost = edge.cost

            if (distance[to] > distance[city] + cost) {
                distance[to] = distance[city] + cost //최단 거리 갱신
                queue.add(to)
            }
        }
    }

    return distance[end]
}
