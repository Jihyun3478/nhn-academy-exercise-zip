import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Input x:");
            int input1 = Integer.parseInt(sc.nextLine());
            System.out.println("Input y:");
            int input2 = Integer.parseInt(sc.nextLine());

            double x = (double) input1;
            double y = (double) input2;

            double answer = Math.sqrt(x*x + y*y);
            System.out.printf("Result: %.2f", answer);

        } catch (NumberFormatException e) {
            System.out.println("Please enter a digit!");
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }
    }
}
