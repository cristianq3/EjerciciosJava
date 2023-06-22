import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();

        int factorial = 1;
        int contador = 1;

        do {
            factorial *= contador;
            contador++;
        } while (contador <= numero);

        System.out.println("El factorial de " + numero + " es: " + factorial);

        scanner.close();
    }
}