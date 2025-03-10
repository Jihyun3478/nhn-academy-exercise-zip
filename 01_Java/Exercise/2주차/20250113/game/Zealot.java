package game;
public class Zealot extends Unit implements Attackable {
    public Zealot(String s) {
        super(s);
        this.hp = 30;
    }

    public void attack() {
        System.out.println("칼 공격");
    }
}
