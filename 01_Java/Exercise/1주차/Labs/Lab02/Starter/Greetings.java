import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        String myName;
        String name = "";

        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        myName = sc.next();

        System.out.printf("Greetings, %s", myName);
        sc.close();
    }
}