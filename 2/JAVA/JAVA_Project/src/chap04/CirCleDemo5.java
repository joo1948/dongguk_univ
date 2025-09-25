package chap04;

class Circle5{
    double radius;
    String color;

    public Circle5(double radius , String color){
        this.radius = radius;
        this.color = color;
    }
    public Circle5(double radius){
        this(radius, " 파랑");
    }
    public Circle5(String color){
        this(10.0);
    }
    public Circle5(){
        this(10.0,"빨강");
    }
}

public class CirCleDemo5 {
}
