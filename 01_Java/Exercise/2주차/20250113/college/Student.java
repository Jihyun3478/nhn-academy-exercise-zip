package college;
public abstract class Student {
    private int studentNo;
    private String name;

    public void study() {
        System.out.println("자율학습");
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }
}
