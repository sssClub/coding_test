package esak.leesak.week1.boj_1260

import java.io.BufferedReader
import java.io.InputStreamReader

private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var graph: Array<MutableList<Int>>
private lateinit var visited: Array<Boolean>
private var answerDfs = ""

//test
fun main(args: Array<String>) {
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { mutableListOf() }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    repeat(n + 1) { idx ->
        graph[idx].sort()
    }
    visited = Array(n + 1) { false }
    dfs(v)
    println(answerDfs)

    visited = Array(n + 1) { false }
    println( bfs(v))
}

fun dfs(start: Int) {
    if(visited[start]) return
    visited[start] = true
    answerDfs += "$start "
    for(next in graph[start]) {
        dfs(next)
    }
}
/**
 *  start 1
 *  1-> visit f t f f f answer 1
 *  2-> visit f t t f f answer 2
 *  4-> visit f t t t
 * **/
fun bfs(start: Int) : String{
    var answerBfs = ""
    val queue = ArrayDeque<Int>()

    queue.add(start)
    visited[start] = true
    while (queue.isNotEmpty()) {
        val next = queue.removeFirst()
        answerBfs += "$next "
        // 연결된 곳
        for(node in graph[next]) {
            if(visited[node]) continue
            visited[node] = true
            queue.add(node)
        }
    }
    return answerBfs
}
/**      1
 *     2   3
 *       4
 * start 1
 * 1-> que: 1 , visit false true false false false , answer 1
 * 2-> que: 2 , visit false true true false false , answer 1
 * 3-> qeu : 2,3 ,visit false true true ture false, answer 1
 * 4-> que : 2,3,4 visit false true true true true , answer 1
 * while
 * next 2 que 34 visit false true true true true , answer 1,2
 * **/