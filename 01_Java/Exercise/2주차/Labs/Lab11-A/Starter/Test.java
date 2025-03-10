import department.Department;
import student.CollegeBoy;

public class Test {
    public static void main(String[] args) {
        Department department = new Department(1, "Computer Engineering");

        department.addStudent(new CollegeBoy(1, "Celine", "010-1111-2222"));
        department.addStudent(new CollegeBoy(2, "James", "010-2222-3333"));

        for(Object o: department) {
            System.out.println(o);
        }

    }
}
