public class Test {
    public static void main(String[] args) {
        Department<Person> department = new Department(1, "Computer Engineering");

        // department.add(new Student(1, "b"));
        // department.add(new Student(5, "a"));
        // department.add(new Student(2, "c"));

        department.add(new Professor(1, "b", "a"));
        department.add(new Professor(5, "a", "b"));
        department.add(new Professor(2, "c", "c"));

        for (Person person : department) {
            System.out.println(person);
        }

        System.out.println();
        department.sortByName();

        for (Person person : department) {
            System.out.println(person);
        }
    }
}