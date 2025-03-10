public enum DayOfWeek {
    January(1),
    Feburary(2),
    March(3),
    April(4),
    May(5),
    June(6),
    July(7),
    August(8),
    Sepetember(9),
    October(10),
    November(11),
    December(12)
    ;

    private int month;

    DayOfWeek(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }
}