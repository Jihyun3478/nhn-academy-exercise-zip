import java.util.Scanner;

public class Whatday {
    static int[] daysInMonth  = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] monthNames = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "Sepetember", "October", "November", "December"};
    
    public static void main(String[] args) {
        try {
            System.out.println("Enter a digit between 1 and 365: ");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            int dayNum = Integer.parseInt(line);
    
            if(dayNum < 1 || dayNum > 365) {
                throw new IllegalArgumentException("Invalid format day number.");
            }
    
            int monthNum = 0;
    
            for(int i = 0; i < daysInMonth.length; i++) {
                if(dayNum > daysInMonth[i]) {
                    dayNum -= daysInMonth[i];
                    monthNum++;
                } else {
                    break;
                }
            }
    
            /* do {
                if (dayNum > 31) {     // January
                    monthNum++;
                    dayNum -= 31;
                } else {
                    break;
                }
        
                if (dayNum > 28) {     // Feburary
                    monthNum++;
                    dayNum -= 28;
                } else {
                    break;
                }
        
                if (dayNum > 31) {     // March
                    monthNum++;
                    dayNum -= 31;
                } else {
                    break;
                }
        
                if (dayNum > 30) {     // April
                    monthNum++;
                    dayNum -= 30;
                } else {
                    break;
                }
        
                if (dayNum > 31) {     // May
                    monthNum++;
                    dayNum -= 31;
                } else {
                    break;
                }
        
                if (dayNum > 30) {     // June
                    monthNum++;
                    dayNum -= 30;
                } else {
                    break;
                }
        
                if (dayNum > 31) {     // July
                    monthNum++;
                    dayNum -= 31;
                } else {
                    break;
                }
        
                if (dayNum > 31) {     // August
                    monthNum++;
                    dayNum -= 31;
                } else {
                    break;
                }
        
                if (dayNum > 30) {     // September
                    monthNum++;
                    dayNum -= 30;
                } else {
                    break;
                }
        
                if (dayNum > 31) {     // October
                    monthNum++;
                    dayNum -= 31;
                } else {
                    break;
                }
        
                if(dayNum > 30) {     // November
                    monthNum++;
                    dayNum -= 30;
                } else {
                    break;
                }
        
                if(dayNum > 31) {     // December
                    monthNum++;
                    dayNum -= 31;
                } else {
                    break;
                }
            } while (false); */
    
            String monthName = monthNames[monthNum];
            
            System.out.printf("%s, %d", monthName, dayNum);
            sc.close();
            
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}