/* Visitor */
public class SpaceShip {
    public void visit(Planet planet) {
        System.out.println("What do I do?");
    }

    public void visit(Mercury planet) {
        System.out.println("Check temp");
    }

    public void visit(Mars planet) {
        System.out.println("Check existance of water");
    }

    public void visit(Jupyter planet) {
        System.out.println("Gatter gas");
    }
}
