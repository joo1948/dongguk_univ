package Chap09_again;

public class GenMethod1Demo {
    static class Utils{
        public static <T> void showArray(T[] a){
            for(T t: a){
                System.out.printf("%s ", t);
            }
            System.out.println();
        }

        public static <T> T getLast(T[] a){
            return a[a.length -1];
        }
    }

    public static void main(String[] args){
        Integer[] ia = {1,2,3,4,5};
        Character[] ca = {'H', 'E', 'L', 'L', 'O'};

        Utils.showArray(ia);
        Utils.showArray(ca);
        //바로 써주기 가능
        Utils.<Integer>showArray(ia);
        Utils.<Character>showArray(ca);
        //구체적으로 타입 명시 가능

        System.out.println(Utils.getLast(ia));
        System.out.println(Utils.<Character>getLast(ca));

    }
}
