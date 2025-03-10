public class Student {
    int no;
    String name;
    String department;

    public Student(int no, String name, String department) {
        this.no = no;
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return this.no + ", " + this.name + ", " + this.department;
    }
}
