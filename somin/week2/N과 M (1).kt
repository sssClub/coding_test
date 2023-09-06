package week2

import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val (N, M) = reader.readLine().split(" ").map { it.toInt() }

    val stack = IntArray(M)
    backTracking(stack, 0, N, M)
}

fun backTracking(stack: IntArray, idx: Int, N: Int, M: Int) {
    for (i in 1..N) { // N개 검사할 거임
        if (!stack.contains(i)) { // 만약 없으면 넣어주기
            stack[idx] = i
            if (idx < M - 1) {
                backTracking(stack, idx + 1, N, M)
            } else {
                println(stack.joinToString(" "))
            }
            stack[idx] = 0
        }
    }
}
