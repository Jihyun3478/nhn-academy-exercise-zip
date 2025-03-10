public class Overriding {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

 class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}