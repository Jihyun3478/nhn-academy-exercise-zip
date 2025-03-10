public class Valkyrie extends Unit implements Flyable, Attackable {
    public Valkyrie() {
        super("Valkyrie", 12, 4);
    }

    @Override
    public void attack(Unit target) {
        target.defense -= this.attackPower;
    }
}
