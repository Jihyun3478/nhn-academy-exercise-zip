public class Zealot extends Unit implements NonFlyable, Attackable {
    public Zealot() {
        super("Zealot", 20, 5);
    }

    @Override
    public void attack(Unit target) {
        if (target instanceof Flyable) {
            System.out.println(name + "은 날아다니는 유닛을 공격할 수 없습니다.");
            return;
        }
        target.defense -= this.attackPower;
    }
}
