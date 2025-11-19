package Chap09_again;

public class GenericClass3Demo {
    public static void main(String[] args){
        Cup c = new Cup();//Raw 타입으로 선언 마치 Object 가 Cup 클래스에 설정된 것 마냥

        c.setBeverage(new Beer());
        Beer b1 = (Beer)c.getBeverage();
        //Beer b1 = c.getBeverage(); // 불가능 제네릭 설정을 하지 않았기 때문


    }
}
