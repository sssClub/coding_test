import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))
lateinit var gym: List<Int>
lateinit var check: IntArray
var cnt = 0

fun main() {
    val (N, K) = reader.readLine().split(" ").map { it.toInt() }
    gym = reader.readLine()!!.split(" ").map { it.toInt() }
    check = IntArray(N) { 9 }
    workOut(500, 0, N, K)
    println("$cnt")
}

fun workOut(weight: Int, idx: Int, N: Int, K: Int) {
    for (i in 0..N - 1) {
        val todayWeight = weight + gym[i] - K
        if (!check.contains(i) && 500 <= todayWeight) { // 운동한 적 없는 기구면
            check[idx] = i
            if (idx < N - 1) workOut(todayWeight, idx + 1, N, K)
            else cnt += 1
        }
        check[idx] = 9
    }
}
