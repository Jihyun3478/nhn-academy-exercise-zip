import department.Department;
import student.CollegeBoy;
import student.StudentNameComparator;

public class Test {
    public static void main(String[] args) {
        Department<CollegeBoy> department = new Department<>(1, "Computer Engineering");
        department.addStudent(new CollegeBoy(3, "Celine", "010-1111-2222"));
        department.addStudent(new CollegeBoy(1, "James", "010-2222-4444"));
        department.addStudent(new CollegeBoy(6, "Adriana", "010-3333-4444"));
        department.addStudent(new CollegeBoy(4, "Robert", "010-4444-4444"));
        department.addStudent(new CollegeBoy(7, "William", "010-5555-4444"));

        for(CollegeBoy c: department) {
            System.out.println(c);
        }

        System.out.println();
        department.sort();

        for(CollegeBoy c: department) {
            System.out.println(c);
        }

        System.out.println();
        department.sort(new StudentNameComparator());

        for(CollegeBoy c: department) {
            System.out.println(c);
        }
    }
}
