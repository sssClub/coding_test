import java.io.BufferedReader
import java.io.InputStreamReader

data class Edge(val from: Int, val to: Int, val weight: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val edges = mutableListOf<Edge>()

    repeat(e) {
        val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
        edges.add(Edge(from, to, weight))
    }

    //오름차순 정렬
    edges.sortBy { it.weight }

    val parent = IntArray(v + 1) { it }
    var result = 0

    for (edge in edges) {
        val cost = edge.weight
        val a = edge.from
        val b = edge.to
        if (find(parent, a) != find(parent, b)) {
            union(parent, a, b)
            result += cost
        }
    }

    println(result)

}

fun find(parent: IntArray, node: Int): Int {
    if (parent[node] == node) return node
    parent[node] = find(parent, parent[node])
    return parent[node]
}

fun union(parent: IntArray, a: Int, b: Int) {
    val rootA = find(parent, a)
    val rootB = find(parent, b)
    if (rootA != rootB) {
        parent[rootA] = rootB
    }
}
