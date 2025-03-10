import java.util.Scanner;

public class Whatday {
    static int[] daysInMonth  = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] daysInLeapMonth  = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static DayOfWeek dayOfWeek;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            System.out.print("Enter year number: ");
            String line = sc.nextLine();
            int yearNum = Integer.parseInt(line);

            boolean isLeapYear = (yearNum % 4 == 0) &&
                                (yearNum % 100 != 0 || yearNum % 400 == 0);

            int maxDayNum = isLeapYear ? 366 : 365;

            System.out.print("Enter a day number between 1 and " + maxDayNum + ": ");
            line = sc.nextLine();
            int dayNum = Integer.parseInt(line);

            if(dayNum < 1 || dayNum > maxDayNum) {
                throw new IllegalArgumentException("Out of range");
            }

            int monthNum = 0;

            if(isLeapYear) {
                for (int days: daysInLeapMonth) {
                    if (dayNum <= days) {
                        break;
                    }
                    else {
                        dayNum -= days;
                        monthNum++;
                    }
                }
            } else {
                for (int days: daysInMonth) {
                    if (dayNum <= days) {
                        break;
                    }
                    else {
                        dayNum -= days;
                        monthNum++;
                    }
                }
            }

            for(DayOfWeek dayOfWeek : dayOfWeek.values()) {
                if((monthNum + 1) == dayOfWeek.getMonth()) {
                    System.out.printf("%s, %d \n", dayOfWeek.name(), dayNum);
                }
            }
            sc.close();

        } catch (NumberFormatException e) {
            System.out.println("Something wrong");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}