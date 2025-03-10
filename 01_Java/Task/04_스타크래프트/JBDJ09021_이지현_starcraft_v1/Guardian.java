public class Guardian extends Unit implements Flyable, Attackable {
    public Guardian() {
        super("Guardian", 6, 3);
    }

    @Override
    public void attack(Unit target) {
        target.defense -= this.attackPower;
    }
}
