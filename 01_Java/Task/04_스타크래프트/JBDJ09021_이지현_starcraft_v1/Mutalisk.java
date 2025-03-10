public class Mutalisk extends Unit implements Flyable, Attackable {
    public Mutalisk() {
        super("Mutalisk", 8, 2);
    }

    @Override
    public void attack(Unit target) {
        target.defense -= this.attackPower;
    }
}
