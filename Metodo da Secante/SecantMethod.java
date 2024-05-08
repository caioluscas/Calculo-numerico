import java.util.Scanner;

public class SecantMethod {
    // Função para calcular o valor da função em um determinado ponto
    public static double function(double x) {
        return Math.pow(x, 3) - 2 * Math.pow(x, 2) - 5; // Função x^3 - 2x^2 - 5
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x0, x1, x2 = 0, erro; // Inicializando x2 com um valor padrão
        int Ni, cont;

        System.out.println("Informe um valor para 'a' no intervalo [a,b]:");
        x0 = scanner.nextDouble();
        System.out.println("Informe um valor para 'b' no intervalo [a,b]:");
        x1 = scanner.nextDouble();
        System.out.println("Informe o valor do erro:");
        erro = scanner.nextDouble();
        System.out.println("Informe o número máximo de interações:");
        Ni = scanner.nextInt();

        double c = x1 - x0;
        System.out.println("\nK \t   x0 \t\t        F(x0) \t\t      x1 \t\t F(x1) \t\t     x2 \t\t F(x2)");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        cont = 0;
        while (Math.abs(function(x2)) > erro) {
            x2 = x1 - function(x1) * ((x1 - x0) / (function(x1) - function(x0)));
            System.out.printf("%d \t| %.2f \t| F(%.2f) = %.4f \t| %.2f \t| F(%.2f) = %.4f \t| %.2f \t| F(%.2f) = %.4f\n",
                    cont + 1, x0, x0, function(x0), x1, x1, function(x1), x2, x2, function(x2));
            c = x1 - x0;
            x0 = x1;
            x1 = x2;
            cont++;
            if (cont >= Ni || Math.abs(x1 - x0) < erro || Math.abs(function(x1)) < erro) {
                break;
            }
        }

        System.out.println("\n--------------------------------");
        System.out.printf("\nNúmero de Iterações: %d.\nRaiz: %.6f.\nF(%.6f) = %.6f.\n", cont, x2, x2, function(x2));

        scanner.close();
    }
}
