public class Wraith extends Unit implements Flyable, Attackable {
    public Wraith() {
        super("Wraith", 10, 3);
    }

    @Override
    public void attack(Unit target) {
        target.defense -= this.attackPower;
    }
}
