import java.util.Scanner;

public class ManejoOracion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String oracion = "";        
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    if (oracion.isEmpty()) {
                        System.out.println("Crear oración");
                        System.out.print("Ingrese una oración: ");
                        scanner.nextLine(); // Consumir el salto de línea anterior
                        oracion = scanner.nextLine();
                    } else {
                        System.out.println("Borrar oración");
                        oracion = "";
                    }
                    break;
                case 2:
                    System.out.println("Cantidad de caracteres de la oración: " + contarCaracteres(oracion));
                    break;
                case 3:
                    System.out.println("Cantidad de palabras de la oración: " + contarPalabras(oracion));
                    break;
                case 4:
                    System.out.println("Palabras ordenadas alfabéticamente: ");
                    mostrarPalabrasOrdenadas(oracion);
                    break;
                case 5:
                    System.out.print("Ingrese un número: ");
                    int numero = scanner.nextInt();
                    mostrarPalabraPorPosicion(oracion, numero);
                    break;
                case 6:
                    System.out.print("Ingrese una palabra: ");
                    scanner.nextLine(); // Consumir el salto de línea anterior
                    String palabraBuscar = scanner.nextLine();
                    buscarPalabra(oracion, palabraBuscar);
                    break;
                case 7:
                    modificarPalabra(oracion, scanner);
                    break;
                case 8:
                    System.out.print("Ingrese contenido a agregar: ");
                    scanner.nextLine(); // Consumir el salto de línea anterior
                    String contenido = scanner.nextLine();
                    oracion += " " + contenido;
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Crear oración / Borrar oración");
        System.out.println("2. Cantidad de caracteres de la oración");
        System.out.println("3. Cantidad de palabras de la oración");
        System.out.println("4. Mostrar palabras ordenadas alfabéticamente");
        System.out.println("5. Ingresar un número y devolver la palabra correspondiente");
        System.out.println("6. Buscar palabra dentro de la oración");
        System.out.println("7. Modificar palabra dentro de la oración");
        System.out.println("8. Agregar contenido a la oración");
        System.out.println("9. Salir");
        System.out.println("-----------------");
    }
    
    public static int contarCaracteres(String oracion) {
        return oracion.length();
    }
    
    public static int contarPalabras(String oracion) {
        String[] palabras = oracion.split(" ");
        return palabras.length;
    }
    
    public static void mostrarPalabrasOrdenadas(String oracion) {
        String[] palabras = oracion.split(" ");
        java.util.Arrays.sort(palabras);
        
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
    
    public static void mostrarPalabraPorPosicion(String oracion, int numero) {
        String[] palabras = oracion.split(" ");
        
        if (numero >= 1 && numero <= palabras.length) {
            System.out.println("Palabra correspondiente: " + palabras[numero - 1]);
        } else {
            System.out.println("Número inválido. Intente nuevamente.");
        }
    }
    
    public static void buscarPalabra(String oracion, String palabraBuscar) {
        String[] palabras = oracion.split(" ");
        
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals(palabraBuscar)) {
                System.out.println("La palabra '" + palabraBuscar + "' fue encontrada en la posición " + (i + 1));
                return;
            }
        }
        
        System.out.println("La palabra '" + palabraBuscar + "' no fue encontrada en la oración.");
    }
    
    public static void modificarPalabra(String oracion, Scanner scanner) {
        System.out.print("Ingrese la palabra a modificar: ");
        scanner.nextLine(); // Consumir el salto de línea anterior
        String palabraModificar = scanner.nextLine();
        
        String[] palabras = oracion.split(" ");
        
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals(palabraModificar)) {
                System.out.print("Ingrese la nueva palabra: ");
                String nuevaPalabra = scanner.nextLine();
                palabras[i] = nuevaPalabra;
                
                String nuevaOracion = String.join(" ", palabras);
                System.out.println("Nueva oración modificada: " + nuevaOracion);
                return;
            }
        }
        
        System.out.println("La palabra '" + palabraModificar + "' no fue encontrada en la oración.");
    }}