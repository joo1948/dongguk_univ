package chap04;

class Circle2{
    private double radius;

    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        this.radius =r;
    }

    double findArea(){
        return 3.14 * radius * radius;

    }

    void show(double x, double y){
        System.out.printf("반지름 = %.1f, 넓이 = %.1f\n", x,y);
    }
}

public class CircleDemo2 {
    public static void main(String[] args){
        Circle2 myCircle2 = new Circle2();

        myCircle2.setRadius(10.0);

        myCircle2.show(myCircle2.getRadius(), myCircle2.findArea());
    }
}
