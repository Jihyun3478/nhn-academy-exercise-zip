public class Goliath extends Unit implements NonFlyable, Attackable, Weaponable {
    public Goliath() {
        super("Goliath", 15, 5);
    }

    @Override
    public void attack(Unit target) {
        target.defense -= this.attackPower;
    }

    @Override
    public boolean useWeapon() {
        return true;
    }
}
