package student;

public abstract class Student {
    protected int studentNo;
    protected String name;
    protected String cellphone;

    public Student(int studentNo, String name, String cellphone) {
        this.studentNo = studentNo;
        this.name = name;
        this.cellphone = cellphone;
    }

    public int getStudentNo() {
        return this.studentNo;
    }

    public String getName() {
        return this.name;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    @Override
    public String toString() {
        return this.studentNo + ", " + this.name + ", " + this.cellphone;
    }
}