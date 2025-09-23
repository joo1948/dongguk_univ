package chap04;

public class LocalVariableDemo {
    public static void main(String[] args){

        int a =0;
        double b;

        //System.out.println(b);//초기화 되어 있지 않아 사용 불가
        //System.out.println(a+c); //c변수는 선언되지 않아서 사용 X

        int c = 0;

        //public double d = 0.0;//지역변수는 public 지정 불가

        for(int e = 0 ;e<10;e++){
            //int a = 1;//3행에서 선언된 지역변수 이름이다. 블록 달라도 같은이름으로 다시 선언 불가능하다.
            System.out.println(e);

        }
    }
}
