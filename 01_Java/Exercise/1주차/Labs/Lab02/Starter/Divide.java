import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first digit: ");
            String temp = sc.nextLine();
            int i = Integer.parseInt(temp);
    
            System.out.print("Enter second digit: ");
            temp = sc.nextLine();
            int j = Integer.parseInt(temp);
    
            int k = i / j;
            
            System.out.printf("%d / %d = %d", i, j ,k);
            sc.close();
            
        } catch (NumberFormatException e) {
            System.out.println("Please enter a digit!");
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }
    }
}
