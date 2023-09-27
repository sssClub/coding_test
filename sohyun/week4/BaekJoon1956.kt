import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (v, e) = br.readLine().split(" ").map { it.toInt() }

    val inf = 100000000
    val dp = Array(v + 1) { IntArray(v + 1) { inf } }

    for (i in 1..v) {
        dp[i][i] = 0
    }

    for (i in 0 until e) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        dp[a][b] = c
    }

    for (k in 1..v) {
        for (i in 1..v) {
            for (j in 1..v) {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])
            }
        }
    }

    var minCycle = Int.MAX_VALUE
    for (i in 1..v) {
        for (j in 1..v) {
            if (i != j) {
                minCycle = min(minCycle, dp[i][j] + dp[j][i])
            }
        }
    }

    if (minCycle == inf) {
        println(-1)
    } else {
        println(minCycle)
    }
}