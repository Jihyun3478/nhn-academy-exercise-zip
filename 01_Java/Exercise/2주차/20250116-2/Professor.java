public class Professor implements Person {
    private int employeeNo;
    private String name;
    private String major;

    public Professor(int employeeNo, String name, String major) {
        this.employeeNo = employeeNo;
        this.name = name;
        this.major = major;
    }

    public int getNo() {
        return employeeNo;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public int compareTo(Person pe) {
        return this.getNo() - pe.getNo();
    }

    @Override
    public String toString() {
        return this.employeeNo + ", " + this.name + ", " + this.major;
    }
}
