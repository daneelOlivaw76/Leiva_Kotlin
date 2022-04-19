package eu.ruimgreis.myplayer

abstract class Person(name: String, val age: Int) {
    var name = name
    get() = "Hello $field"
    set(value){
        if(field != value){
            field = value
        }
    }
}

class Developer(name: String): Person(name, 30) {
}

fun test(){
    val d = Developer("Tom")
    val name = d.name
    d.name = "Rick"
}