import java.util.*;

public class JBDJ09021_starcraft {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("내 종족을 결정하세요(0: Terran, 1: Protos, 2: Zerg): ");
        int playerChoice = scanner.nextInt();
        scanner.nextLine();

        Race playerRace = createRace(playerChoice);
        Race computerRace = createRace(new Random().nextInt(3));

        boolean playerTurn = true;
        while (playerRace.hasUnits() && computerRace.hasUnits()) {
            System.out.println("내 유닛: ");
            playerRace.displayUnits();
            System.out.println();
            System.out.println("적군: ");
            computerRace.displayUnits();
            System.out.println();
            
            if (playerTurn) {
                System.out.println("내 유닛과 공격할 상대 유닛을 입력하십시오(ex - 0 2): ");
                int myUnitIndex = scanner.nextInt();
                int enemyUnitIndex = scanner.nextInt();
                scanner.nextLine();

                Unit myUnit = playerRace.getUnit(myUnitIndex);
                Unit enemyUnit = computerRace.getUnit(enemyUnitIndex);
                myUnit.attack(enemyUnit);

                if (enemyUnit.isDestroyed()) {
                    System.out.println(enemyUnit.name + "가 파괴되었습니다!");
                }
            } else {
                System.out.println("적의 턴입니다.");
                Unit computerUnit = computerRace.getUnit(new Random().nextInt(computerRace.units.size()));
                Unit targetUnit = playerRace.getUnit(new Random().nextInt(playerRace.units.size()));
                computerUnit.attack(targetUnit);

                if (targetUnit.isDestroyed()) {
                    System.out.println(targetUnit.name + "가 파괴되었습니다!");
                }
            }

            playerTurn = !playerTurn;
        }

        if (playerRace.hasUnits()) {
            System.out.println("승리했습니다!");
        } else {
            System.out.println("패배했습니다.");
        }
    }

    private static Race createRace(int choice) {
        Race race;
        switch (choice) {
            case 0:
                race = new Race("Terran");
                race.addUnit(new Marine());
                race.addUnit(new Tank());
                race.addUnit(new Goliath());
                race.addUnit(new Wraith());
                race.addUnit(new Valkyrie());
                break;
            case 1:
                race = new Race("Protos");
                race.addUnit(new Zealot());
                race.addUnit(new Dragon());
                race.addUnit(new HighTempler());
                race.addUnit(new Scout());
                race.addUnit(new Corsair());
                break;
            case 2:
                race = new Race("Zerg");
                race.addUnit(new Zergling());
                race.addUnit(new Hydralisk());
                race.addUnit(new Ultralisk());
                race.addUnit(new Mutalisk());
                race.addUnit(new Guardian());
                break;
            default:
                throw new IllegalArgumentException("잘못된 선택입니다.");
        }
        return race;
    }
}