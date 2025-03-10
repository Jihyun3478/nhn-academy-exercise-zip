public interface IPrintable {
    void print();
}

class Message implements IPrintable {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
