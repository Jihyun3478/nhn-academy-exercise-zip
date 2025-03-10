import java.util.*;

public class Race {
    String name;
    List<Unit> units;

    public Race(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    public boolean hasUnits() {
        return units.stream().anyMatch(unit -> !unit.isDestroyed());
    }

    public void displayUnits() {
        for (int i = 0; i < units.size(); i++) {
            Unit unit = units.get(i);
            if (!unit.isDestroyed()) {
                System.out.println(i + ". " + unit);
            }
        }
    }

    public Unit getUnit(int index) {
        return units.get(index);
    }
}
