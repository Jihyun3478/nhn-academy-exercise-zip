package game;

public abstract class Unit {
    protected int hp;
    protected String name;
    protected int location;

    public Unit(String s) {
        this.name = s;
    }

    public void move(int x) {
        this.location = x;
    }
}
