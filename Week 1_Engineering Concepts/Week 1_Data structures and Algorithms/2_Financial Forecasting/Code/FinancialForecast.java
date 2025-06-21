import java.util.Scanner;

public class FinancialForecast {
    public static double predictFutureValueRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + growthRate / 100);
        return predictFutureValueRecursive(nextValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();

        double futureValueRecursive = predictFutureValueRecursive(initialValue, growthRate, years);
        System.out.printf("Future value after %d years: %.2f%n", years, futureValueRecursive);

        scanner.close();
    }
}