package com.jesse.c24kkgnad

fun main() {
    fAdd(1, 2)
    fAdd2(b = 2)
    fAdd3(2, 3)
    println(fAdd4(3, 4))
    fWhen(5)
    fList()
}

fun fAdd(a: Int, b: Int) {
    println("Sum of $a and $b is ${a + b}")
}

fun fAdd2(a: Int = 1, b: Int) {
    println("Sum2 of $a and $b is ${a + b}")
}

fun fAdd3(a: Int = 1, b: Int): Int {
    println("Sum2 of $a and $b is ${a + b}")
    return a + b
}

fun fAdd4(a: Int = 1, b: Int) = a + b

fun fWhen(a: Any) {
    when (a) {
        is Int -> println("Int")
        is String -> println("String")
        else -> println("Unknown")
    }
}

fun fList() {
    println("")
    val inmutableList = listOf("a", "b", "c")
    println(inmutableList)
    val isB1 = "b" in inmutableList
    val isB2 = inmutableList.contains("b")
    val name: String = inmutableList[0] //access by index
    println("$isB1 $isB2 $name\n")
    // answer   [a, b, c]
    //          true true a

    val valMutableList = mutableListOf("a", "b", "c")
    println(valMutableList)
    val isB = inmutableList.filter { it == "b" } //b
    valMutableList[1] = "Dart" // update item in list
    valMutableList.add("Ketty") // add item
    valMutableList.add(2, "Carl") // add item at index
    println(valMutableList) //[a, Dart, Carl, c, Ketty]
    val removedC = valMutableList.remove("c")
    println(valMutableList)//[a, Dart, Carl, Ketty]

    var varMutableList = mutableListOf("a", "b", "c")
    varMutableList[0] = "Ellen"
    println(varMutableList)//[Ellen, b, c]
    varMutableList = mutableListOf("Gemma", "Harry")
    println(varMutableList)//[Gemma, Harry]
}