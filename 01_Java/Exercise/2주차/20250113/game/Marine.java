package game;
public class Marine extends Unit implements Attackable {
    public Marine(String s) {
        super(s);
        this.hp = 15;
    }

    public void attack() {
        System.out.println("기관총 공격!");
    }
}
