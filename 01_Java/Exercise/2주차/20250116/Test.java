public class Test {
    public static void main(String[] args) {
        Department department = new Department(1, "Computer Eniginerring");

        department.add(new Student(1, "Jihyun"));
        department.add(new Student(2, "James"));
        department.add(new Student(3, "Json"));

        for(Student student : department) {
            System.out.println(student);
        }
    }
}

class Student {
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
}