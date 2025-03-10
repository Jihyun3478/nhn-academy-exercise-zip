interface Flyable {}
class Hero {}
class IronMan extends Hero implements Flyable {}
class Hulk extends Hero {}

public class Sample {
    public static void main(String[] args) {
        IronMan iron = new IronMan();
        System.out.println(iron instanceof Flyable);
    }
}
