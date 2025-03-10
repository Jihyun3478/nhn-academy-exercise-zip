public class SuperC {
    protected int i;

    public SuperC(int i) {
        this.i = i;
    }
}

class SubC extends SuperC {
    private int j;

    public SubC(int i, int j) {
        super(i);
        this.j = j;
    }
}