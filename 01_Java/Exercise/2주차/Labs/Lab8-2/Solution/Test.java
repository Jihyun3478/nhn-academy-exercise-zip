public class Test {
    public static void main(String[] args) {
        int i = 0;
        Integer number = 1;
        String s = "Hello";

        System.out.println(Utilities.isCharSequence(i));
        System.out.println(Utilities.isCharSequence(number));
        System.out.println(Utilities.isCharSequence(s));

        Message message = new Message("Greetings");
        Utilities.display(number);
        Utilities.display(message);
    }
}