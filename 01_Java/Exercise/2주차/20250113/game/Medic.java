package game;
public class Medic extends Unit implements Attackable {
    public Medic(String s) {
        super(s);
        this.hp = 10;
    }

    public void heal(Marine marine) {
        marine.hp += 1;
    }

    public void attack() {
        System.out.println("화염 공격");
    }
}
