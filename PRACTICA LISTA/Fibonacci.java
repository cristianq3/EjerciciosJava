import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        Scanner Dato = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de términos a imprimir: ");
        int n = Dato.nextInt(); // Cantidad de términos a imprimir
        int term1 = 0; // Primer término
        int term2 = 1; // Segundo término
        int count = 0; // Contador

        System.out.println("Serie de Fibonacci:");

        while (count < n) {
            System.out.print(term1 + " ");

            int sum = term1 + term2;
            term1 = term2;
            term2 = sum;

            count++;
        }
    }
}