public class Mars implements Planet {
    public void accept(SpaceShip ship) {
        ship.visit(this);
    }
}
