package week2.boj_7576

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var answer = 0
var cnt = 0
var nums = 0
var queue: Queue<IntArray> = LinkedList()
lateinit var box: Array<IntArray>
private val reader = BufferedReader(InputStreamReader(System.`in`))
fun main() {
    val (width, height) = reader.readLine().split(" ").map { it.toInt() }
    box = Array(height) { IntArray(width) { 0 } }
    repeat(height) { i ->
        box[i] = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
        for ((idx, value) in box[i].withIndex()) {
            when (value) {
                0 -> nums += 1
                1 -> queue.add(intArrayOf(i, idx))
            }
        }
    }
    queue.add(intArrayOf(-1, -1))
    getTomatoes(width, height)
}

private fun getTomatoes(width: Int, height: Int) {
    while (1 < queue.size) {
        val (y, x) = queue.remove()
        if (x == -1 && 0 < queue.size) {
            answer++
            queue.add(intArrayOf(-1, -1))
        } else {
            if (x < width - 1) ripeningTomato(y, x + 1)
            if (y < height - 1) ripeningTomato(y + 1, x)
            if (0 < x) ripeningTomato(y, x - 1)
            if (0 < y) ripeningTomato(y - 1, x)
        }
    }
    if (cnt < nums) {
        answer = -1
    }
    println(answer)
}

private fun ripeningTomato(y: Int, x: Int) {
    if (box[y][x] == 0) {
        box[y][x] = 1
        queue.add(intArrayOf(y, x))
        cnt++
    }
}