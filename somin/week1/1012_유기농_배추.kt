import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))
lateinit var graph: Array<Array<Int>>

fun main() {
    val T = reader.readLine().toInt()
    repeat(T) {
        val (width, height, nums) = reader.readLine().split(" ").map { it.toInt() }
        graph = Array(height) { Array(width) { 0 } } // 세로 크기 height 가로 크기 width 2차원 배열
        getCabbageNums(width, height, nums)
    }
}

fun check(i: Int, j: Int, width: Int, height: Int) {
    if (graph[i][j] == 1) {
        graph[i][j] = 0
        if (j != 0) check(i, j - 1, width, height)
        if (i != 0) check(i - 1, j, width, height)
        if (j != width - 1) check(i, j + 1, width, height)
        if (i != height - 1) check(i + 1, j, width, height)
    }
}

fun getCabbageNums(width: Int, height: Int, nums: Int) {
    repeat(nums) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
        graph[y][x] = 1
    }
    var answer = 0

    for (i in 0 until height) {
        for (j in 0 until width) {
            if (graph[i][j] == 1) {
                graph[i][j] = 0
                if (i != height - 1) check(i + 1, j, width, height)
                if (j != width - 1) check(i, j + 1, width, height)
                answer += 1
            }
        }
    }
    println(answer)
}
