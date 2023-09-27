package esak.leesak.week4

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: MutableList<MutableList<Int>>

fun main() {

    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    graph = MutableList(v + 1) { MutableList(v + 1) { 0 } }
    var result = 0
    repeat(e) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a][b] = c
    }
    //여기가 메인 코드
    /**
     * 구글링 해보았는데 왜 뎁쓰가 3이나 필요하지 궁금했음
     * 1,1 = min(1,1 , 1,1 +1,1)
     * ...... 이런순으로 모든 방향을 확인하는 거였음
     * 계속 써보면 1,2 + 1,3 맨뒤에 방향이 바껴서 순환지 까지 구하고 최소 값으로 바꿔줌
     * **/
    for (k in 1..v) {
        for (i in 1..v) {
            for (j in 1..v) {
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }
    // 이부분을 통해서 어떻게 돌아 왔는지 알 수 있는 코드
    repeat(v + 1) {
        result = min(graph[it][it], result)
    }
    if (result == 0) result = -1
    println(result)
}

/**
 *  1  -- 1  --- 2
 *  -           -    2---3 3
 *    5       1 2
 *     -    -
 *        3
 *
 *
 *
 *
 * **/