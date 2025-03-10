public enum Day {
    SUNDAY("일요일"),
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일"),
    SATURDAY("토요일")
    ;

    private String korMonthName;

    Day(String korMonthName) {
        this.korMonthName = korMonthName;
    }

    public String getKorMonthName() {
        return korMonthName;
    }
}

class Date {
    private int year, month, day;
    Day dayOfWeek;

    public void setDate(int year, int month, int day, Day dayOfWeek) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }

    public String toString() {
        return (year + "년 " + month + "월 " + day + "일 " + dayOfWeek.getKorMonthName());
    }
}

class Test {
    public static void main(String[] args) {
        Date date1 = new Date();
        date1.setDate(2025, 1, 14, Day.TUESDAY);
        System.out.println(date1.toString());

        Date date2 = new Date();
        date2.setDate(2025, 1, 21, Day.TUESDAY);
        System.out.println(date2.toString());

        System.out.println(date1.dayOfWeek == date2.dayOfWeek);
    }
}