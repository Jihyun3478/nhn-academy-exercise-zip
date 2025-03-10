import java.util.Random;
import java.util.Scanner;

public class JBDJ09021_Tictactoe {
    private static String[][] tictactoe = {
        {" ", " ", " "},
        {" ", " ", " "},
        {" ", " ", " "}
    };
    private static String winner = "";

    public static void playUser() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("사용자 턴(x y): ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (!validateRange(x, y) || !validateAlreadyCheck(x, y)) {
                throw new IllegalArgumentException("Invalid input. Please enter again!");
            }
            tictactoe[x][y] = "O";
            break;
        }
    }

    private static boolean validateRange(int x, int y) {
        return x >= 0 || x < 3 || y >= 0 || y < 3;
    }

    private static boolean validateAlreadyCheck(int x, int y) {
        return tictactoe[x][y].equals(" ");
    }

    public static void playComputer() {
        Random random = new Random();
        System.out.println("컴퓨터 턴");
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (tictactoe[x][y].equals(" ")) {
                tictactoe[x][y] = "X";
                break;
            }
        }
    }

    public static void printTictactoe() {
        for (String[] row : tictactoe) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(" " + row[j] + " ");
                if (j != row.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.println("-----------");
        }
        System.out.println();
    }

    public static void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (tictactoe[i][0].equals(tictactoe[i][1]) && tictactoe[i][1].equals(tictactoe[i][2]) && !tictactoe[i][0].equals(" ")) {
                winner = tictactoe[i][0].equals("O") ? "사용자" : "컴퓨터";
            }
            if (tictactoe[0][i].equals(tictactoe[1][i]) && tictactoe[1][i].equals(tictactoe[2][i]) && !tictactoe[0][i].equals(" ")) {
                winner = tictactoe[0][i].equals("O") ? "사용자" : "컴퓨터";
            }
        }

        if (tictactoe[0][0].equals(tictactoe[1][1]) && tictactoe[1][1].equals(tictactoe[2][2]) && !tictactoe[0][0].equals(" ")) {
            winner = tictactoe[0][0].equals("O") ? "사용자" : "컴퓨터";
        }
        if (tictactoe[0][2].equals(tictactoe[1][1]) && tictactoe[1][1].equals(tictactoe[2][0]) && !tictactoe[0][2].equals(" ")) {
            winner = tictactoe[0][2].equals("O") ? "사용자" : "컴퓨터";
        }
    }

    public static void main(String[] args) {
        while (winner.isBlank()) {
            try {
                playUser();
                printTictactoe();
                checkWinner();
                if (!winner.isBlank()) {
                    break;
                }

                playComputer();
                printTictactoe();
                checkWinner();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.printf("%s 승리", winner);
    }
}
