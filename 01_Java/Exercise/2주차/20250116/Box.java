public class Box<T> {
    T no;

    public Box(T no) {
        this.no = no;
    }

    public T getNo() {
        return this.no;
    }
}

class Test {
    public static void main(String[] args) {
        Box<Integer> box = new Box<Integer>(1);
        System.out.println(box.getNo());

        Box<String> stringBox = new Box<String>("Jihyun");
        System.out.println(stringBox.getNo());
    }
}