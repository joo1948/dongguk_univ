package chap10;

interface NewObject2<T> {T getObject(T o);};
interface NewArray2<T> {T[] getArray(int size);}

public class ConstructorRefDeom {
    public static void main(String[] args){
        NewObject<String> s;
        NewArray<Integer> i;

        //s = x-> new String(x);
        s = String::new;
        String str = s.getObject("사과");

        //i = x-> new Integer[x];
        i = Integer[]::new;

        Integer[] array = i.getArray(2);
        array[0] = 10;
        array[1] = 20;
    }
}
