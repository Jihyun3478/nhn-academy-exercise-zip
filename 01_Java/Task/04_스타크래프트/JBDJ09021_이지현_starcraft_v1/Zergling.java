public class Zergling extends Unit implements NonFlyable, Attackable {
    public Zergling() {
        super("Zergling", 2, 2);
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
