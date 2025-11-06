package Chap09;

public class TryCatch1Demo {
    public static void main(String[] args){
        int[] array = {0,1,2};
        try{
            System.out.println("마지막 원소 => " + array[3]);
            System.out.println("첫 번째 원소 => " + array[0]);
            //일반예외, 실행예외 구분
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("원소가 존재 x");
        }
        System.out.println("어이쿠!");
    }
}
