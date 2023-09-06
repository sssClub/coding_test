import java.io.BufferedReader
import java.io.InputStreamReader

class BeakJoon15649 {
}

var visited = booleanArrayOf()
val sb = StringBuilder()

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = this.readLine().split(" ").map { it.toInt() }
    visited = BooleanArray(n)
    visited.fill(false)
    backtracking(n, m, 0, IntArray(m))
    println(sb.toString())
}


fun backtracking(n: Int, m: Int, depth: Int, result: IntArray) {
    if (depth == m) {
        for (i in 0 until m) sb.append("${result[i]} ")
        sb.append("\n")
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            result[depth] = i + 1
            backtracking(n, m, depth + 1, result)
            visited[i] = false
        }
    }
}