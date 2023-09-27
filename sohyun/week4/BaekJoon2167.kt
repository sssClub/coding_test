import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val array = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val dp = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            dp[i][j] = array[i][j]

            if (i > 0) {
                dp[i][j] += dp[i - 1][j]
            }
            if (j > 0) {
                dp[i][j] += dp[i][j - 1]
            }
            if (i > 0 && j > 0) {
                dp[i][j] -= dp[i - 1][j - 1] //겹치는 부분합 제거
            }
        }
    }

    val k = br.readLine().toInt()
    repeat(k) {
        val (i, j, x, y) = br.readLine().split(" ").map { it.toInt() }
        var result = dp[x - 1][y - 1]

        if (i > 1) {
            result -= dp[i - 2][y - 1]
        }
        if (j > 1) {
            result -= dp[x - 1][j - 2]
        }
        if (i > 1 && j > 1) {
            result += dp[i - 2][j - 2] //겹치는 부분합 추가
        }

        println(result)
    }

}