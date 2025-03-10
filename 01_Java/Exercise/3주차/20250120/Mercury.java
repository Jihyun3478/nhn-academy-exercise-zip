public class Mercury implements Planet {
    public void accept(SpaceShip ship) {
        ship.visit(this);
    }
}
