public class Hydralisk extends Unit implements NonFlyable, Attackable, Weaponable {
    public Hydralisk() {
        super("Hydralisk", 7, 3);
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
