import java.io.BufferedReader
import java.io.InputStreamReader

class BeakJoon18429 {
}

var visited = booleanArrayOf()
val sb = StringBuilder()
lateinit var kit: MutableList<Int>
var count = 0

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = this.readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(n)
    visited.fill(false)
    kit = this.readLine().split(" ").map { it.toInt() } as MutableList<Int>
    backtracking(n, k, 0, 500)
    sb.append("$count")
    println(sb.toString())
}


fun backtracking(n: Int, k: Int, depth: Int, sum: Int) {
    if (depth == n) {
        count++
        return
    }

    for (i in 0 until n) {
        if (!visited[i] && (sum + kit[i] - k >= 500)) {
            visited[i] = true
            backtracking(n, k, depth + 1, sum + kit[i] - k)
            visited[i] = false
        }
    }
}