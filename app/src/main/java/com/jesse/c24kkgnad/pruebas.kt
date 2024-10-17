package com.jesse.c24kkgnad

import java.util.UUID

fun main(){

   // reduceFold()
   // getrandomList()
}

fun reduceFold() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val sum = numbers.reduce { acc, element -> acc + element }
    println(sum) // 15
    val sumFold = numbers.fold(5) { acc, element -> acc + element }
    println(sumFold) // 20
    val sumFold2 = numbers.fold("") { acc, element -> acc + element }
    println(sumFold2) // "12345
}

fun getrandomList() {
    val letters = ('a'..'z').toList()
    println(letters) //[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
    val randomList = List(5) { letters.random() } // una forma de hacerlos aleatorios
    println(randomList)//[f, g, s, n, v]
    val randomList2 = letters.shuffled().take(5) // mismo resultado con otra forma
    println(randomList2)//[a, b, c, d, e]
    val randomList3 = (1..20).map { letters.random() } // otra forma de hacerlo
    println(randomList3)
    val numbers = (1..5).map { (1..50).random() } // lista de numeros aleatorios
    println(numbers) //[11, 48, 40, 40, 4}
}