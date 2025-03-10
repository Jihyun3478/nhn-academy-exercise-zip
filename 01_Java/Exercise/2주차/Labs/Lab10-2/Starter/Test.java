public class Test {
    public static void main(String[] args) {
        // Department department = new Department();
        // department.addStudent(new Student("Jihyun", 1));
        // department.addStudent(new Student("James", 2));

        // Enumerator enumerator = department.students.getEnumerator();
        // while (enumerator.hasNext()) {
        //     Student student = (Student) enumerator.next();
        //     System.out.println(student.getName());
        // }

        try {
            // List list = new ArrayList();
            List list = new LinkedList();

            list.add(0);
            list.add(1);
            list.add(2);
            // list.iterator();

            Enumerator enumerator = list.getEnumerator();
            System.out.print("enumerator: ");
            while(enumerator.hasNext()) {
                System.out.print(enumerator.next() + " ");
            }

            list.remove(1);
            System.out.println();
            // list.iterator();

            System.out.println("isEmpty: " + list.isEmpty());

            System.out.println("size: " + list.size());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
