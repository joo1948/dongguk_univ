package chap04;

class Circle4{
    double radius;
    String color;

    public Circle4(double r, String c){
        radius = r;
        color = c;
    }

    public Circle4(double r){
        radius = r;
        color = "파랑";
    }

    public Circle4(String c){
        radius = 10.0;
        color = c;
    }

    public Circle4(){
        radius = 10.0;
        color = "빨강";
    }

}

public class CircleDemo4 {
    public static void main(String[] args){
        Circle4 c1 = new Circle4(10.0,"빨강");
        Circle4 c2 = new Circle4(5.0);
        Circle4 c3 = new Circle4("노랑");
        Circle4 c4 = new Circle4();

    }
}
