package student;

public class CollegeBoy extends Student {
    private String doubleMajor;

    public CollegeBoy(int studentNo, String name, String cellphone) {
        super(studentNo, name, cellphone);
    }

    public CollegeBoy(int studentNo, String name, String cellphone, String doubleMajor) {
        super(studentNo, name, cellphone);
        this.doubleMajor = doubleMajor;
    }

    public String getDoubleMajor() {
        return this.doubleMajor;
    }

    @Override
    public String toString() {
        if (this.doubleMajor != null) {
            return this.studentNo + ", " + this.name + ", " + this.cellphone + ", " + this.doubleMajor;
        }
        else {
            return this.studentNo + ", " + this.name + ", " + this.cellphone;
        }
    }
}
