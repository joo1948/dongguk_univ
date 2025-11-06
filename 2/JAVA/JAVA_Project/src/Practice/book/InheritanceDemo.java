package Practice.book;

public class InheritanceDemo {
    public static void main(String[] args){

        Circle c1 = new Circle();
        Ball b1 = new Ball("red");

        System.out.println("==원==");
        c1.findRadius(); // 반지름 10
        c1.findArea(); // 넓이는 파이 * r * r

        System.out.println("\n 공");
        b1.findRadius(); // 반지름 10.0
        b1.findArea(); // 바ㄵ름
        b1.findColor();
        b1.findVolumne();

        Ball b = new Ball("rad");
        Circle c = new Circle();

        c=b;

        b = (Ball)c;

        b.findVolumne();
        b.findArea();





    }
}
