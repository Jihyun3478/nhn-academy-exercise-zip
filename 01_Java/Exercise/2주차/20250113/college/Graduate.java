package college;
public class Graduate extends Student {
    private String major;
    private String professor;

    @Override
    public void study() {
        System.out.println("채찍을 맞으며 공부");
    }

    public void project() {

    }
}
