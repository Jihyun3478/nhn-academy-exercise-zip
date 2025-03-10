import java.util.Arrays;

public class Student implements Comparable<Student> {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return this.no;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student s) {
        return this.getNo() - s.getNo();
    }

    @Override
    public String toString() {
        return this.no + " " + this.name;
    }
}

class Test {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "bruno"), 
            new Student(2, "jihyun"), 
            new Student(3, "ariana")
        };

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for(Student student : students) {
            System.out.println(student.getNo() + ", " + student.getName());
        }
        
        Arrays.sort(students);

        for(Student student : students) {
            System.out.println(student.getNo() + ", " + student.getName());
        }
    }
}