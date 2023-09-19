package esak.leesak.week3.boj_9655

import java.io.BufferedReader
import java.io.InputStreamReader

private val br = BufferedReader(InputStreamReader(System.`in`))


// 이렇게 풀어도 정답이긴 하네 ㅋㅋ
//fun main(){
//    val n = br.readLine().toInt()
//    if (n%2==0){
//        println("CY")
//    }else{
//        println("SK")
//    }
//}

fun main(){
    val n = br.readLine().toInt()
    val dp = Array(1001){"SK"}
    dp[2] = "CY"
    for ( i in dp.indices){
        if (i%2==0) dp[i]="CY"
    }
//        for ( i in 4 until dp.size){
//            if(dp[i-3]=="SK" && dp[i-1]=="SK") dp[i]="CY"
//    }
    println(dp[n])
}
/**
 * 1 상근이
 * 2 창영이
 * 3 상근이
 * 4 창영이
 * 5 상근이
 * 6 창영이
 *
 * **/