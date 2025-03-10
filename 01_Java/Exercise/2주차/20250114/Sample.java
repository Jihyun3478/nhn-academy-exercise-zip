public class Sample {
    private int i;
    private String name;

    public Sample(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public static void changeSomething(int i) {
        i++;
    }

    public static void main(String[] args) {
        Sample sample = new Sample(1, "Jihyun");
        
    }
}