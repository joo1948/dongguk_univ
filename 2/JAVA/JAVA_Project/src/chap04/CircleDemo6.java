package chap04;

class Circle6{
    double radius;
    static int numOfCircles =0 ;
    int numCircles = 0;

    public Circle6(double radius){
        this.radius = radius;
        numOfCircles++;
        numCircles++;
    }

}

public class CircleDemo6 {
    public static void main(String[] args){
        Circle6 myCircle = new Circle6(10.0);
        Circle6 yourCircle = new Circle6(5.0);

        System.out.println("원의 개수 : " + Circle6.numOfCircles);
        System.out.println(("원의 개수 : "  + yourCircle.numCircles));


    }

    void print(){
        System.out.println("인스턴스메서드입니다.");
    }
}
