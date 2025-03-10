import java.util.*;

/* 인터페이스 사용 고민 */
abstract class Unit {
    String name;
    int defense;
    int attackPower;

    public Unit(String name, int defense, int attackPower) {
        this.name = name;
        this.defense = defense;
        this.attackPower = attackPower;
    }

    public abstract void attack(Unit target);

    public boolean isDestroyed() {
        return this.defense <= 0;
    }

    public String toString() {
        return name + " (방어력: " + defense + ", 공격력: " + attackPower + ")";
    }
}
