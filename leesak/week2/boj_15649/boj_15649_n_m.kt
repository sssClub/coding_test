package esak.leesak.week2.boj_15649

import java.io.BufferedReader
import java.io.InputStreamReader

private val br = BufferedReader(InputStreamReader(System.`in`))
private val graph = mutableListOf<Int>()
private lateinit var visited: MutableList<Boolean>

fun main(){
    val (n,m)= br.readLine().split(" ").map{it.toInt()}
    visited= MutableList(n){false}
    dfs(n,m)
}


private fun dfs(n:Int,m:Int){
    if (m==graph.size){
        graph.forEach{
            print("$it ")
        }
        println()
        return
    }

    for (i in 0 until n){
        if (!visited[i]){
            graph.add(i+1)
            visited[i]=true
            dfs(n,m)
            visited[i]=false
            graph.removeLast()
        }
    }
}