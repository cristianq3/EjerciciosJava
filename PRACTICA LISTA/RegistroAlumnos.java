import java.util.Scanner;

public class RegistroAlumnos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nombres = new String[100];
        double[] notas = new double[100];
        int cantidadAlumnos = 0;

        int opcion;
        do {
            System.out.println("---- Registro de Alumnos ----");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Mostrar todos los alumnos");
            System.out.println("3. Mostrar promedio de notas");
            System.out.println("4. Buscar alumno por nombre");
            System.out.println("5. Modificar nota por nombre");
            System.out.println("6. Eliminar alumno por nombre");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del alumno: ");
                    String nombre = scanner.nextLine();
                    if (nombre.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    System.out.print("Ingrese la nota del alumno: ");
                    double nota = scanner.nextDouble();
                    if (nota < 0 || nota > 10) {
                        System.out.println("La nota debe ser un número válido entre 0.00 y 10.00.");
                        break;
                    }

                    nombres[cantidadAlumnos] = nombre;
                    notas[cantidadAlumnos] = nota;
                    cantidadAlumnos++;
                    System.out.println("Alumno registrado exitosamente.");
                    break;

                case 2:
                    if (cantidadAlumnos == 0) {
                        System.out.println("No hay alumnos registrados.");
                        break;
                    }

                    System.out.println("---- Listado de Alumnos ----");
                    for (int i = 0; i < cantidadAlumnos; i++) {
                        System.out.println("Nombre: " + nombres[i] + ", Nota: " + notas[i]);
                    }
                    break;

                case 3:
                    if (cantidadAlumnos == 0) {
                        System.out.println("No hay alumnos registrados.");
                        break;
                    }

                    double sumaNotas = 0;
                    for (int i = 0; i < cantidadAlumnos; i++) {
                        sumaNotas += notas[i];
                    }
                    double promedio = sumaNotas / cantidadAlumnos;
                    System.out.println("Promedio de notas: " + promedio);
                    break;

                case 4:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del alumno a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < cantidadAlumnos; i++) {
                        if (nombres[i].equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Nombre: " + nombres[i] + ", Nota: " + notas[i]);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró al alumno.");
                    }
                    break;

                case 5:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del alumno a modificar su nota: ");
                    String nombreModificar = scanner.nextLine();
                    boolean modificado = false;

                    for (int i = 0; i < cantidadAlumnos; i++) {
                        if (nombres[i].equalsIgnoreCase(nombreModificar)) {
                            System.out.print("Ingrese la nueva nota del alumno: ");
                            double nuevaNota = scanner.nextDouble();
                            if (nuevaNota < 0 || nuevaNota > 10) {
                                System.out.println("La nota debe ser un número válido entre 0.00 y 10.00.");
                                break;
                            }

                            notas[i] = nuevaNota;
                            modificado = true;
                            System.out.println("Nota modificada exitosamente.");
                            break;
                        }
                    }

                    if (!modificado) {
                        System.out.println("No se encontró al alumno.");
                    }
                    break;

                case 6:
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    System.out.print("Ingrese el nombre del alumno a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    boolean eliminado = false;

                    for (int i = 0; i < cantidadAlumnos; i++) {
                        if (nombres[i].equalsIgnoreCase(nombreEliminar)) {
                            for (int j = i; j < cantidadAlumnos - 1; j++) {
                                nombres[j] = nombres[j + 1];
                                notas[j] = notas[j + 1];
                            }
                            cantidadAlumnos--;
                            eliminado = true;
                            System.out.println("Alumno eliminado exitosamente.");
                            break;
                        }
                    }

                    if (!eliminado) {
                        System.out.println("No se encontró al alumno.");
                    }
                    break;

                case 7:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

            System.out.println(); // Salto de línea
        } while (opcion != 7);

        scanner.close();
    }
}