class reservaUsuario {
    var idReserva = 0
    var idHuesped = 0
    var nombreHuesped = ""
    var emailHuesped = ""
    var numeroHabitacion = 0
    var tipoHabitacion = ""
    var precioPorNoche = 0.0
    var cantidadNoches = 0

    constructor()
    constructor(
        idReserva: Int,
        idHuesped: Int,
        nombreHuesped: String,
        emailHuesped: String,
        numeroHabitacion: Int,
        tipoHabitacion: String,
        precioPorNoche: Double,
        cantidadNoches: Int
    ) {
        this.idReserva = idReserva
        this.idHuesped = idHuesped
        this.nombreHuesped = nombreHuesped
        this.emailHuesped = emailHuesped
        this.numeroHabitacion = numeroHabitacion
        this.tipoHabitacion = tipoHabitacion
        this.precioPorNoche = precioPorNoche
        this.cantidadNoches = cantidadNoches
    }

    fun calcularMontoTotal(): Double {
        return precioPorNoche * cantidadNoches
    }

    companion object {
        fun registrarReserva(listaReservas: MutableList<reservaUsuario>) {
            println("Ingrese ID de reserva:")
            val idReserva = readLine()!!.toInt()
            println("Ingrese ID del huésped:")
            val idHuesped = readLine()!!.toInt()
            println("Ingrese nombre del huésped:")
            val nombreHuesped = readLine()!!
            println("Ingrese email del huésped:")
            val emailHuesped = readLine()!!
            println("Ingrese número de habitación:")
            val numeroHabitacion = readLine()!!.toInt()
            println("Ingrese tipo de habitación:")
            val tipoHabitacion = readLine()!!
            println("Ingrese precio por noche:")
            val precioPorNoche = readLine()!!.toDouble()
            println("Ingrese cantidad de noches:")
            val cantidadNoches = readLine()!!.toInt()

            val habitacionOcupada = listaReservas.any { it.numeroHabitacion == numeroHabitacion }
            if (habitacionOcupada) {
                println("Habitación ya reservada.")
            } else {
                val nuevaReserva = reservaUsuario(
                    idReserva,
                    idHuesped,
                    nombreHuesped,
                    emailHuesped,
                    numeroHabitacion,
                    tipoHabitacion,
                    precioPorNoche,
                    cantidadNoches
                )
                listaReservas.add(nuevaReserva)
                println("Reserva registrada.")
            }
        }

        fun cancelarReserva(listaReservas: MutableList<reservaUsuario>) {
            println("Ingrese ID de reserva para que se pueda cancelar:")
            val idReserva = readLine()!!.toInt()
            val reserva = listaReservas.find { it.idReserva == idReserva }
            if (reserva != null) {
                listaReservas.remove(reserva)
                println("Reserva cancelada.")
            } else {
                println("Reserva no se puedo ubicarr.")
            }
        }

        fun mostrarReservas(listaReservas: MutableList<reservaUsuario>) {
            if (listaReservas.isEmpty()) {
                println("No hay reservas.")
            } else {
                listaReservas.forEach {
                    println("ID Reserva: ${it.idReserva}, Huésped: ${it.nombreHuesped}, Habitación: ${it.numeroHabitacion}, Monto Total: ${it.calcularMontoTotal()}")
                }
            }
        }
    }
}