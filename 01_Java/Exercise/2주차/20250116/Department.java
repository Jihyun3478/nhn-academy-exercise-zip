import java.util.Collections;

public class Department implements Iterable<Student> {
    ArrayList<String> list;
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
        this.list = new ArrayList();
    }
    public void Department() {
        this.list = new ArrayList();
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void add(Student student) {
        this.list.add(student);
    }
    
    public void sort() {
        Collections.sort(list);
    }

    public Iterator<Student> Iterator() {
        return list.iterator;
    }
}
