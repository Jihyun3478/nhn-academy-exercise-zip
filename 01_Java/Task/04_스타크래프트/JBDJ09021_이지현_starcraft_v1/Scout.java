public class Scout extends Unit implements Flyable, Attackable {
    public Scout() {
        super("Scout", 10, 5);
    }

    @Override
    public void attack(Unit target) {
        target.defense -= this.attackPower;
    }
}
