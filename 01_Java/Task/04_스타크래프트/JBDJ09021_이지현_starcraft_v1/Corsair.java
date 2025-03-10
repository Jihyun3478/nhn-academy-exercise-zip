public class Corsair extends Unit implements Flyable, Attackable {
    /* 싱글톤 사용 고민 */
    public Corsair() {
        super("Corsair", 12, 4);
    }

    @Override
    public void attack(Unit target) {
        target.defense -= this.attackPower;
    }
}
