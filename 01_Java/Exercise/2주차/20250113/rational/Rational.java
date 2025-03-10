package rational;
public class Rational {
    protected int numerator;
    protected int denominator;

    public Rational(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("denominator cant't be zero!");
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Rational add(Rational r) {
        int numerator = (this.numerator * r.denominator) + (this.denominator * r.numerator);
        int denominator = this.denominator * r.denominator;

        return new Rational(numerator, denominator);
    }

    public Rational substract(Rational r) {
        int numerator = (this.numerator * r.denominator) - (this.denominator * r.numerator);
        int denominator = this.denominator * r.denominator;
        
        return new Rational(numerator, denominator);
    }

    public Rational times(Rational r) {
        if(this.denominator != r.denominator) {
            this.denominator = this.denominator * r.denominator;
            this.numerator = (this.numerator * r.numerator) + (this.denominator * r.numerator);
        }
        else {
            this.numerator = this.numerator * r.numerator;
            this.denominator = this.denominator * r.denominator;
        }
        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational r) {
        this.numerator = this.numerator * r.denominator;
        this.denominator = this.denominator * r.numerator;

        return new Rational(numerator, denominator);
    }

    private int gcd(int n, int d) {
        if (d == 0) {
            return n;
        } else {
            return gcd(d, n % d);
        }
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}

class Test {
    public static void main(String[] args) {
        try {
            Rational r1 = new Rational(1, 2);
            Rational r2 = new Rational(1, 2);
            Rational temp1 = r1.add(r2);
            System.out.println(temp1.toString());
    
            Rational r3 = new Rational(1, 2);
            Rational r4 = new Rational(1, 2);
            Rational temp2 = r3.substract(r4);
            System.out.println(temp2.toString());
    
            Rational r5 = new Rational(1, 2);
            Rational r6 = new Rational(1, 2);
            Rational temp3 = r5.times(r6);
            System.out.println(temp3.toString());
    
            Rational r7 = new Rational(1, 2);
            Rational r8 = new Rational(1, 2);
            Rational temp4 = r7.divide(r8);
            System.out.println(temp4.toString());
        } catch (IllegalArgumentException e) {

        }
    }
}