package department;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import student.Student;

public class Department<E extends Student> implements Iterable<E> {
    public int departmentNo;
    public String departmentName;
    public List<E> list;

    public Department(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        this.list = new ArrayList<>();
    }

    public int getDepartmentNo() {
        return this.departmentNo;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void addStudent(E e) {
        this.list.add(e);
    }

    public Iterator<E> iterator() {
        return this.list.iterator();
    }

    public void sort() {
        Collections.sort(this.list, new student.StudentNoComparator());
    }

    public void sort(Comparator<Student> comparator) {
        Collections.sort(this.list, comparator);
    }
}
