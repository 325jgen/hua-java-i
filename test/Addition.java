import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1;
        int num2;
        int sum;

        System.out.print("Enter first integer: ");
        num1 = input.nextInt();

        System.out.print("Enter second integer: ");
        num2 = input.nextInt();

        sum = num1 + num2;

        System.out.printf("Sum is %d%n", sum);
    }
}