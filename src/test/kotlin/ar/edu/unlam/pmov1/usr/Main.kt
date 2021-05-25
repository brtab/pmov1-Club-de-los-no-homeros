package ar.edu.unlam.pmov1.usr

var nuevoBar = ar.edu.unlam.pmov1.src.Bar()

fun main() {
    println("Bienvenido al Bar!")
    println("Ingrese el nombre del bar..")
    val nombre: String? = readLine().toString() ?: "Bar de Moe"
    nuevoBar.setNombre(nombre!!)
    iniciarBar()
    nuevoBar.abrirElBar()

    mostrarMenu()
    seleccionarOpcion()
}

fun seleccionarOpcion() {
    var opcion: Int? = readLine()?.toInt() ?: 11
    when (opcion) {
        1,2,3 -> {
            println("Ingresar en modo homero para esta funcion")
            ingresarModoHomero()
        }
    }
}

fun ingresarModoHomero() {
    TODO("Not yet implemented")
}

fun iniciarBar() {
    println("Abra el bar para comtinuar")
    do {
        println("¿Abrir el bar? S/N")
    } while (!readLine().toString().uppercase().equals("S"))
}

fun mostrarMenu() {
    println("Bar ${nuevoBar.getNombre()}")
    println("Seleccionar Opcion:")
    println("1 - Ingresar cliente")
    println("2 - Listar clientes dentro del bar")
    println("3 - Ordenar clientes dentro del bar")
    println("0 - Salir")
}