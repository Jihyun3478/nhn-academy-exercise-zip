package student;

public class Graduate extends Student {
    private String major;

    public Graduate(int studentNo, String name, String cellphone, String major) {
        super(studentNo, name, cellphone);
        this.major = major;
    }

    public String getMajor() {
        return this.major;
    }

    @Override
    public String toString() {
        return this.studentNo + ", " + this.name + ", " + this.cellphone + ", " + this.major;
    }
}
