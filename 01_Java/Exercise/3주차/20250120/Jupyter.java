public class Jupyter implements Planet {
    public void accept(SpaceShip ship) {
        ship.visit(this);
    }
}
