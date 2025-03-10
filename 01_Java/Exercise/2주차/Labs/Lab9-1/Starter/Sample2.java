interface Printable {
    int returnAsInt();
    default long returnAsLong() {
        int i = returnAsInt();
        return (long) i;
    }
}

class Integer implements Printable {
    int i;
    
    public int returnAsInt() {
        return i;
    }
}

class Long implements Printable {
    long l;

    public int returnAsInt() {
        return (int) l;
    }
}