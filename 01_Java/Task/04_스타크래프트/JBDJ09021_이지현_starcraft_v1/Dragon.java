public class Dragon extends Unit implements NonFlyable, Attackable, Weaponable {
    public Dragon() {
        super("Dragon", 15, 3);
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
