import java.util.Scanner;

public class VerificarPrimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        boolean esPrimo;

        do {
            System.out.print("Ingrese un número: ");
            numero = scanner.nextInt();
            esPrimo = verificarPrimo(numero);

            if (!esPrimo) {
                System.out.println("El número no es primo. Intente de nuevo.");
            }
        } while (!esPrimo);

        System.out.println("El número ingresado (" + numero + ") es primo.");

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