/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package matias.fcmanager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import matias.fcmanager.model.Player;
import matias.fcmanager.model.Staff;
import matias.fcmanager.model.Team;
import matias.fcmanager.model.Transaction;
import matias.fcmanager.model.Event;
import matias.fcmanager.model.Finance;
import matias.fcmanager.model.Match;
import matias.fcmanager.model.Calendar;

/**
 *
 * @author matin
 */

// Funcionando Actualmente:
// Se pueden gestionar equipo, registro de jugadores y personal del equipo y ver el equipo completo con sus respectivos datos relevantes.
// Se pueden gestionar calendario, registro de eventos y ver los eventos registrados.
// Se pueden gestionar finanzar, registro de transacciones y ver el reporte financiero.
// Se pueden gestionar partidos, registrar partidos y ver información de los partidos.

public class FCManager {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Team equipo = new Team("Independiente San Felipe", LocalDate.of(1987, 10, 15), "Ricardo Palma", "Lima", "Peru", "Liga Distrital de Carabayllo");
        
        while (true) {
            System.out.println("\n--- Menu FCManager ---");
            System.out.println("1. Gestionar Equipo");
            System.out.println("2. Gestionar Calendario");
            System.out.println("3. Gestionar Partidos");
            System.out.println("4. Gestionar Finanzas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea restante

            switch (opcion) {
                case 1:
                    // Gestión del equipo
                    while (true) {
                    System.out.println("\n--- Gestión de Equipo ---");
                    System.out.println("1. Registrar jugador");
                    System.out.println("2. Registrar personal");
                    System.out.println("3. Mostrar equipo");
                    System.out.println("4. Volver al menú principal");
                    System.out.print("Seleccione una opción: ");
                    int opcionGestionEquipo = scanner.nextInt();
                    scanner.nextLine(); // Consumir salto de línea
            
                    switch (opcionGestionEquipo) {
                        case 1:
                            // Registrar jugador
                            System.out.println("Ingrese el nombre del jugador: ");
                            String jugador_nombre = scanner.nextLine();
                            System.out.println("Ingrese el apellido del jugador: ");
                            String jugador_apellido = scanner.nextLine();
                            System.out.println("Ingrese la fecha de nacimiento del jugador (yyyy-mm-dd): ");
                            String jugador_fechaNacimientoInput = scanner.nextLine();
                            LocalDate jugador_fechaNacimiento = validarFecha(jugador_fechaNacimientoInput);
            
                            System.out.println("Ingrese la nacionalidad del jugador: ");
                            String jugador_nacionalidad = scanner.nextLine();
                            System.out.println("Ingrese la posición del jugador: ");
                            String jugador_posicion = scanner.nextLine();
                            System.out.println("Ingrese el número de camiseta del jugador: ");
                            int jugador_numeroCamiseta = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea restante
                            System.out.println("Ingrese la fecha de inicio del contrato del jugador (yyyy-mm-dd): ");
                            String jugador_fechaInicioContratoInput = scanner.nextLine();
                            LocalDate jugador_fechaInicioContrato = validarFecha(jugador_fechaInicioContratoInput);
            
                            System.out.println("Ingrese el salario del jugador: ");
                            double jugador_salario = scanner.nextDouble();
                            scanner.nextLine(); // Consumir el salto de línea restante
            
                            // Crear jugador
                            Player jugador = new Player(
                                jugador_nombre,
                                jugador_apellido,
                                jugador_posicion,
                                jugador_fechaNacimiento,
                                jugador_nacionalidad,
                                jugador_numeroCamiseta,
                                jugador_fechaInicioContrato,
                                jugador_salario
                            );
                            
                            equipo.addPlayer(jugador);
                            System.out.println("Jugador registrado exitosamente.");
                            break;
            
                        case 2:
                            // Registrar personal
                            System.out.println("Ingrese el nombre del personal: ");
                            String personal_nombre = scanner.nextLine();
                            System.out.println("Ingrese el apellido del personal: ");
                            String personal_apellido = scanner.nextLine();
                            System.out.println("Ingrese la fecha de nacimiento del personal (yyyy-mm-dd): ");
                            String personal_fechaNacimientoInput = scanner.nextLine();
                            LocalDate personal_fechaNacimiento = validarFecha(personal_fechaNacimientoInput);
            
                            System.out.println("Ingrese la nacionalidad del personal: ");
                            String personal_nacionalidad = scanner.nextLine();
                            System.out.println("Ingrese el rol del personal: ");
                            String personal_rol = scanner.nextLine();
                            System.out.println("Ingrese la fecha de inicio del contrato del personal (yyyy-mm-dd): ");
                            String personal_fechaInicioContratoInput = scanner.nextLine();
                            LocalDate personal_fechaInicioContrato = validarFecha(personal_fechaInicioContratoInput);
            
                            System.out.println("Ingrese el salario del personal: ");
                            double personal_salario = scanner.nextDouble();
                            scanner.nextLine(); // Consumir el salto de línea restante
            
                            // Crear personal
                            Staff personal = new Staff(
                                personal_nombre,
                                personal_apellido,
                                personal_fechaNacimiento,
                                personal_nacionalidad,
                                personal_rol,
                                personal_fechaInicioContrato,
                                personal_salario
                            );
                            
                            equipo.addStaff(personal);
                            System.out.println("Personal registrado exitosamente.");
                            break;
            
                        case 3:
                            // Mostrar equipo
                            System.out.println("\n--- Informe del Equipo ---");
                            System.out.println(equipo.generarInforme());
                            break;
            
                        case 4:
                            // Volver al menú principal
                            System.out.println("Regresando al menú principal...");
                            break;
            
                        default:
                            System.out.println("Opción inválida. Intente de nuevo.");
                    }
                    if (opcionGestionEquipo == 4) break; // Salir del submenú de gestión de equipo
                }
                break;

                case 2:
                    // Gestionar calendario
                    Calendar calendario = new Calendar(); // Deberías usar una instancia global o pasada por referencia
                    while (true) {
                        System.out.println("\n--- Gestión del Calendario ---");
                        System.out.println("1. Agregar evento");
                        System.out.println("2. Mostrar eventos");
                        System.out.println("3. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        int opcionCalendario = scanner.nextInt();
                        scanner.nextLine(); // Consumir salto de línea

                        switch (opcionCalendario) {
                            case 1:
                                System.out.println("Ingrese el título del evento:");
                                String titulo = scanner.nextLine();
                                System.out.println("Ingrese la descripción del evento:");
                                String descripcion = scanner.nextLine();
                                System.out.println("Ingrese la fecha del evento (yyyy-mm-dd):");
                                String fechaInput = scanner.nextLine();
                                LocalDate fecha = validarFecha(fechaInput);
                                System.out.println("Ingrese la hora de inicio (HH:mm):");
                                String horaInicioInput = scanner.nextLine();
                                System.out.println("Ingrese la hora de fin (HH:mm):");
                                String horaFinInput = scanner.nextLine();
                                System.out.println("Ingrese el lugar del evento:");
                                String lugar = scanner.nextLine();

                                // Crear el evento y agregarlo al calendario
                                Event evento = new Event(titulo, descripcion, fecha, 
                                        LocalTime.parse(horaInicioInput), LocalTime.parse(horaFinInput), lugar);
                                calendario.agregarEvento(evento);
                                System.out.println("Evento agregado exitosamente.");
                                break;

                            case 2:
                                // Mostrar todos los eventos
                                System.out.println(calendario.mostrarEventos());
                                break;

                            case 3:
                                // Volver al menú principal
                                System.out.println("Regresando al menú principal...");
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                        }
                        if (opcionCalendario == 3) break; // Salir del bucle del calendario
                    }
                    break;

                case 3:
                    // Gestionar partidos
                    while (true) {
                        System.out.println("\n--- Gestión de Partidos ---");
                        System.out.println("1. Registrar partido");
                        System.out.println("2. Mostrar partidos registrados");
                        System.out.println("3. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        int opcionPartido = scanner.nextInt();
                        scanner.nextLine(); // Consumir salto de línea

                        switch (opcionPartido) {
                            case 1:
                                // Registro de un nuevo partido
                                System.out.println("Ingrese el nombre del equipo oponente:");
                                String equipoOponente = scanner.nextLine();
                                System.out.println("Ingrese la fecha del partido (yyyy-mm-dd):");
                                String fechaPartidoInput = scanner.nextLine();
                                LocalDate fechaPartido = validarFecha(fechaPartidoInput);
                                System.out.println("¿Se jugó en casa? (true/false):");
                                boolean enCasa = scanner.nextBoolean();
                                String estadio;
                                if (enCasa) {
                                    estadio = equipo.getEstadio();
                                } else {
                                    System.out.println("Ingrese el estadio donde se jugó el partido:");
                                    estadio = scanner.nextLine();
                                }
                                System.out.println("Ingrese los goles de su equipo:");
                                int golesLocal = scanner.nextInt();
                                System.out.println("Ingrese los goles del equipo oponente:");
                                int golesVisitante = scanner.nextInt();
                                scanner.nextLine(); // Consumir salto de línea restante

                                // Crear y agregar el partido
                                Match partido = new Match(equipo.getNombreEquipo(), equipoOponente, fechaPartido, enCasa, estadio, golesLocal, golesVisitante);
                                equipo.addMatch(partido);
                                System.out.println("Partido registrado exitosamente.");
                                break;

                            case 2:
                                // Mostrar todos los partidos registrados
                                System.out.println("\n--- Partidos Registrados ---");
                                System.out.println(equipo.mostrarPartidos());
                                break;

                            case 3:
                                // Volver al menú principal
                                System.out.println("Regresando al menú principal...");
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                        }
                        if (opcionPartido == 3) break; // Salir del bucle de partidos
                    }
                    break;

                case 4:
                    // Gestionar finanzas
                    Finance finanzas = new Finance(); // Deberías usar una instancia global o pasada por referencia
                    while (true) {
                        System.out.println("\n--- Gestión de Finanzas ---");
                        System.out.println("1. Registrar transacción");
                        System.out.println("2. Generar reporte financiero");
                        System.out.println("3. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        int opcionFinanzas = scanner.nextInt();
                        scanner.nextLine(); // Consumir salto de línea

                        switch (opcionFinanzas) {
                            case 1:
                                System.out.println("Ingrese la descripción de la transacción:");
                                String descripcion = scanner.nextLine();
                                System.out.println("Ingrese la fecha de la transacción (yyyy-mm-dd):");
                                String fechaInput = scanner.nextLine();
                                LocalDate fecha = validarFecha(fechaInput);
                                System.out.println("Ingrese el monto de la transacción:");
                                double monto = scanner.nextDouble();
                                System.out.println("¿Es un ingreso? (true/false):");
                                boolean esIngreso = scanner.nextBoolean();

                                // Crear la transacción y agregarla
                                Transaction transaccion = new Transaction(descripcion, fecha, monto, esIngreso);
                                finanzas.registrarTransaccion(transaccion);
                                System.out.println("Transacción registrada exitosamente.");
                                break;

                            case 2:
                                // Mostrar reporte financiero
                                System.out.println(finanzas.generarReporte());
                                break;

                            case 3:
                                // Volver al menú principal
                                System.out.println("Regresando al menú principal...");
                                break;

                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                        }
                        if (opcionFinanzas == 3) break; // Salir del bucle de finanzas
                    }
                    break;

                case 5:
                    System.out.println("Saliendo de FCManager...");
                    return;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    // Método para validar fechas puede estar en una clase utilitaria
    private static LocalDate validarFecha(String fechaInput) {
        try {
            return LocalDate.parse(fechaInput);
        } catch (Exception e) {
            System.out.println("Fecha no válida. Intente de nuevo.");
            return null;
        }
    }
}