package Practice;

class Complex{
    double a;
    double b;

    Complex(double a){
        this.a = a;
    }

    Complex(double a, double b){
        this.a = a;
        this.b = b;
    }

    public void print(){

        System.out.printf("%.1f + %.1fi\n", this.a, this.b);

    }
}


public class ComplexTest {
    public static void main(String[] args){
        Complex c1 = new Complex(2.0);
        c1.print();

        Complex c2 = new Complex(1.5, 2.5);
        c2.print();
    }
}
