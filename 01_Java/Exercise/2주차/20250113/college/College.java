package college;
public class College {
    public static void main(String[] args) {
        Student s1 = new Undergraduate();
        s1.setName("Jihyun");
        s1.getName();
        s1.study();

        Graduate s2 = new Graduate();
        s2.setName("Sam");
        s2.study();
        s2.project();
    }
}
