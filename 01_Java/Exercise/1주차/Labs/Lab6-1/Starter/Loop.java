import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";

        while (true) {
            System.out.println("Enter: ");
            s = sc.nextLine();

            if(s.equals("exit")) {
                return;
            }
        }
    }
}
