import org.junit.Test
import kotlin.test.*

class ClienteTest {

    @Test
    fun `que se pueda crear un cliente`() {
        val nombre = "Brian"
        val edad = 28
        val nuevo = Cliente(nombre, edad)

        assertNotNull(nuevo)
    }

}

class BarTest {

    @Test
    fun `que se pueda crear un bar`() {
        var nuevo = Bar()

        assertNotNull(nuevo)

    }

    @Test
    fun `debo poder abrir el bar`() {
        var nuevo = Bar()
        nuevo.abrirElBar()
        assertEquals(nuevo.estaAbierto(), true)
    }
}

class HomeroTest {

    @Test
    fun `Homero no deberia aceptar un cliente si el bar esta cerrado`() {
        val nuevoBar = Bar()
        val nuevoCliente = Cliente("Juan", 30)
        assertFalse(Homero.ingresarCliente(nuevoBar, nuevoCliente))

    }

    @Test
    fun `Homero debe poder aceptar un cliente si el bar se encuentra abierto`(){
        val nuevoBar = Bar()
        val nuevoCliente = Cliente("Juan", 30)
        nuevoBar.abrirElBar()
        assertTrue(Homero.ingresarCliente(nuevoBar, nuevoCliente))
    }

    @Test
    fun `Homero debe poder listar a los clientes en el bar por edad`(){
        val nuevoBar = Bar()
        val cliente1 = Cliente("Primero", 1)
        val cliente2 = Cliente("Segundo", 2)
        val cliente3 = Cliente("Tercero", 3)
        nuevoBar.abrirElBar()
        assertTrue(Homero.ingresarCliente(nuevoBar, cliente3))
        assertTrue(Homero.ingresarCliente(nuevoBar, cliente1))
        assertTrue(Homero.ingresarCliente(nuevoBar, cliente2))
        val lista = Homero.ordenarClientesPorEdad(nuevoBar)
        assertEquals(cliente1, lista[0])
        assertEquals(cliente2, lista[1])
        assertEquals(cliente3, lista[2])
    }

    @Test
    fun `Homero debe poder listar a los clientes en el bar alfabeticamente`(){
        val nuevoBar = Bar()
        val cliente1 = Cliente("a", 1)
        val cliente2 = Cliente("b", 2)
        val cliente3 = Cliente("c", 3)
        nuevoBar.abrirElBar()
        assertTrue(Homero.ingresarCliente(nuevoBar, cliente3))
        assertTrue(Homero.ingresarCliente(nuevoBar, cliente1))
        assertTrue(Homero.ingresarCliente(nuevoBar, cliente2))
        val lista = Homero.ordenarClientesAlfabeticamente(nuevoBar)
        assertEquals(cliente1, lista[0])
        assertEquals(cliente2, lista[1])
        assertEquals(cliente3, lista[2])
    }
}