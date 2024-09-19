@file:Suppress("MagicNumber")

package com.jesse.c24kkgnad

fun main() {
//    fAdd(1, 2)
//    fAdd2(b = 2)
//    fAdd3(2, 3)
//    println(fAdd4(3, 4))
//    fWhen(5)
//    fList()
    //fListAdd()
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
    println("isB: $isB removedC: $removedC")
    var varMutableList = mutableListOf("a", "b", "c")
    varMutableList[0] = "Ellen"
    println(varMutableList)//[Ellen, b, c]
    varMutableList = mutableListOf("Gemma", "Harry")
    println(varMutableList)//[Gemma, Harry]

    valMutableList.add("GG")
    varMutableList.add("HH")
    println(valMutableList)//[Ellen, b, c, GG]
    println(varMutableList)//[Gemma, Harry, HH]
    valMutableList.addAll(varMutableList)
    println(valMutableList)//[Ellen, b, c, GG, Gemma, Harry, HH
    valMutableList.removeAt(0)
    println(valMutableList)//[b, c, GG, Gemma, Harry, HH]
    varMutableList.remove("Harry")
    println(varMutableList)//[Gemma, HH]
    valMutableList.removeAll(varMutableList)
    println(valMutableList)//[b, c, GG, Gemma]
    valMutableList.clear()
    varMutableList.clear()
    println(valMutableList)//[]
    valMutableList.add("a")
    valMutableList.add("b")
    varMutableList = mutableListOf("b", "c", "d")
    println(valMutableList)//[a, b]
    println(varMutableList)//[b, c, d]
    valMutableList.retainAll(varMutableList)
    println(valMutableList)//[b]
    valMutableList.remove("a")
    println(varMutableList)//[b, c, d]
    valMutableList.addAll(varMutableList)
    println(valMutableList)//[a, b, b, c, d]
    valMutableList.removeAll(varMutableList)
    println(valMutableList)//[a]
    valMutableList.forEach { println(it) }
    valMutableList.filter { it == "b"
    }.forEach { println(it) }
}

fun fListAdd(){
    val diasSemana = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    val emptyDays = mutableListOf<String>()
    diasSemana.forEach {
        emptyDays.add(it+"Bl")
    }
    println(diasSemana)
    println(emptyDays)
}
