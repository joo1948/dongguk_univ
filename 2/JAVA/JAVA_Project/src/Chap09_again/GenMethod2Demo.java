package Chap09_again;

public class GenMethod2Demo {
    static class Utils{
        public static <T extends Number> void showArray(T[] a){
            //제네릭에 extends 써주면 메서드도 클래스나 인터페이스와 동일하게 특정 타입으로 제한 할 수있음
            for( T t : a){
                System.out.printf("%s ", t);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Integer[] ia = {1,2,3,4,5};
        Double[] da  = {1.0, 2.0, 3.0, 4.0, 5.0};
        Character[] ca = {'H' , 'E', 'L', 'L', 'O'};

        Utils.showArray(ia);
        Utils.showArray(da);
        //가능 > 모두 number 타입 > 숫자 타입
        //Utils.showArray(ca); // 불가능 > String은 Number 타입이 아님
    }
}
