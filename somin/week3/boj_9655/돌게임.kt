package week3.boj_9655

import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val N = reader.readLine().toInt()
    if(N%2 == 0) println("CY")
    else println("SK")
}
