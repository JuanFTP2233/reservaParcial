fun main() {
    val listareservas = mutableListOf<reservaUsuario>()
    val r1 = reservaUsuario()
    listareservas.add(r1)

    while (true) {
        println("\nMenú")
        println("1Registrar reserva")
        println("2Cancelar reserva")
        println("3Mostrar reservas")
        println("4Salir")
        println("5Seleccione una opción:")

        when (readLine()!!.toInt()) {
            1 -> reservaUsuario.registrarReserva(listareservas)
            2 -> reservaUsuario.cancelarReserva(listareservas)
            3 -> reservaUsuario.mostrarReservas(listareservas)
            4 -> {
                println("fin")
                return
            }
            else -> println("invalida")
        }
    }
}