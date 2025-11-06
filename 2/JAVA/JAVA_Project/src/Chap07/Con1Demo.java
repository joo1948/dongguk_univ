package Chap07;

interface Coin{
    int PENNY = 1, NICKEL =5, DIME = 10, QUARTER = 25;
    //int로 표시되어 있지만, pulbic static final int이다.
    //인터페이스의 모든 필드는 public static final이기 때문
}

public class Con1Demo {
    public static void main(String[] args){
        System.out.println("Dime은 " + Coin.DIME + "센트 입니다.");
    }
}
