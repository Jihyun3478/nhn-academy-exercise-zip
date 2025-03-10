public class Student implements Person {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person pe) {
        return this.getNo() - pe.getNo();
    }

    @Override
    public String toString() {
        return this.no + ", " + this.name;
    }
}