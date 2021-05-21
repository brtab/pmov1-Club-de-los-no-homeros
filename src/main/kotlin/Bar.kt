class Bar() {
    private val clientesDentro: MutableSet<Cliente>
    private var abierto: Boolean

    init {
        abierto = false
        clientesDentro = mutableSetOf()
    }

    fun estaAbierto(): Boolean {
        return abierto
    }

    fun getClientesDentro(): Set<Cliente> {
        return clientesDentro.toSet()
    }

    fun abrirElBar() {
        abierto = true
    }

    internal fun ingresarCliente(nuevo: Cliente): Boolean {
        var operacionExitosa = false
        if (estaAbierto() && !clientesDentro.contains(nuevo)) {
            clientesDentro.add(nuevo)
            operacionExitosa = true
        }
        return operacionExitosa
    }

    private fun opcionEdad(indice: Int, cliente: Cliente, ordenados: MutableList<Cliente>): MutableList<Cliente> {
        if (cliente.edad > ordenados[indice + 1].edad) {
            val cambio = cliente
            ordenados[indice] = ordenados[indice + 1]
            ordenados[indice + 1] = cliente
        }
        return ordenados
    }

    private fun opcionNombre(indice: Int, cliente: Cliente, ordenados: MutableList<Cliente>): MutableList<Cliente> {
        if (cliente.nombre.uppercase().compareTo(ordenados[indice + 1].nombre.uppercase()) > 0) {
            val cambio = cliente
            ordenados[indice] = ordenados[indice + 1]
            ordenados[indice + 1] = cliente
        }
        return ordenados
    }

    private fun ordenarPor(tipo: TipoDeOrden): List<Cliente> {
        var ordenados = clientesDentro.toMutableList()
        try {
            for ((indice, cliente) in ordenados.withIndex()) {
                when (tipo) {
                    TipoDeOrden.EDAD -> ordenados = opcionEdad(indice, cliente, ordenados)
                    TipoDeOrden.NOMBRE -> ordenados = opcionNombre(indice, cliente, ordenados)
                }
            }
        } catch (e: IndexOutOfBoundsException) {

        } finally {
            return ordenados.toList()
        }
    }

    internal fun ordenarPorEdad(): List<Cliente> {
        return ordenarPor(TipoDeOrden.EDAD)
    }

    internal fun ordenarAlfabeticamente(): List<Cliente> {
        return ordenarPor(TipoDeOrden.NOMBRE)
    }

}

object Homero {

    fun ingresarCliente(barActual: Bar, clienteNuevo: Cliente): Boolean {
        return barActual.ingresarCliente(clienteNuevo)
    }

    fun ordenarClientesPorEdad(barActual: Bar): List<Cliente> {
        return barActual.ordenarPorEdad()
    }

    fun ordenarClientesAlfabeticamente(barActual: Bar): List<Cliente> {
        return barActual.ordenarAlfabeticamente()
    }

}

enum class TipoDeOrden {
    EDAD,
    NOMBRE
}

class Cliente(val nombre: String, var edad: Int) {


}