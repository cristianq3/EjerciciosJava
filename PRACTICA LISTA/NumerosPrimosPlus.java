import java.util.Scanner;

public class NumerosPrimosPlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad de números primos a obtener: ");
        int cantidadPrimos = scanner.nextInt(); //780
        
        int numero = 2;
        int contadorPrimos = 0;
        
        while (contadorPrimos < cantidadPrimos) {
            if (verificarPrimo(numero)) {
                System.out.print(" " + numero);
                contadorPrimos++;
            }
            numero++;
        }
        
        scanner.close();
    }
    
    // Función para verificar si un número es primo
    public static boolean verificarPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}