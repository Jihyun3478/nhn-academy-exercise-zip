package department;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import student.Student;

public class Department implements Iterable {
    public int departmentNo;
    public String departmentName;
    public List list;

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

    public void addStudent(Student e) {
        this.list.add(e);
    }

    public Iterator iterator() {
        return this.list.iterator();
    }
}
