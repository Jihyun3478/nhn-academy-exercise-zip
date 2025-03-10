public class Nasa {
    public static void main(String[] args) {
        Planet mars = new Mars();
        Planet mercury = new Mercury();

        SpaceShip ship = new SpaceShip();

        // ship.visit(mars);
        ship.visit(mercury);

        mercury.accept(ship);
        mars.accept(ship);
    }   
}
