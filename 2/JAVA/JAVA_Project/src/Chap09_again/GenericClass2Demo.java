package Chap09_again;

public class GenericClass2Demo {
    public static void main(String[] args){
        Cup<Beer> c = new Cup<Beer>();//Beer타입의 컵 객체 생성
        //Object 대신 제네릭으로 설정하였고, 그 자리에 Beer 가 들어감

        c.setBeverage(new Beer());
        Beer b1 = c.getBeverage(); // (Beer)하지 않아도 상관 X

        //c.setBeverage(new Boricha());//불가능 > 이미 제네릭으로 <Beer>객체 선언
        b1 = c.getBeverage();
    }
}
