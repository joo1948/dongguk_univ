package TEST_1127;

import java.util.*;

//프로세스 할 함수형 인터페이스 구
interface StringProcessor2 {
    int process(String s);
}

abstract class StringManipulator {
    protected String[] array;

    public StringManipulator(String[] array) {
        this.array = array;
    }

    public abstract int manipulate();
}


class UpperManipulator extends StringManipulator {
    public UpperManipulator(String[] array) {
        super(array);
    }


    public int manipulate() {
        long sum = 0;

        for (String s : array) {
            String upperStr = s;


            upperStr = upperStr.toUpperCase();


            if (upperStr.length() >= 5) {
                upperStr = upperStr.substring(0, upperStr.length() - 2);
            }


            int hashCode = upperStr.hashCode();


            sum += hashCode;
        }

        return (int) sum;
    }
}


class LowerManipulator extends StringManipulator {
    public LowerManipulator(String[] array) {
        super(array);
    }


    public int manipulate() {
        long sum = 0;

        for (String s : array) {
            String lowerStr = s;


            lowerStr = lowerStr.toLowerCase();


            if (lowerStr.length() <= 3) {
                lowerStr = lowerStr.substring(1);
            }

            int hashCode = lowerStr.hashCode();
            sum += hashCode;
        }

        return (int) sum;
    }
}

public class Problem3 {

    static StringProcessor2 process1 = s -> {

        /*
        * 1. 문자열에서 index 1번 2번 3번만 지워야 함.
        * 2. 그런데 fig 같이 index 0,1,2만 있는 경우 index 1,2,3중 있는 1,2만 지우는 것
        * 3. 이렇게 만든 새로운 문자열의 String.hashCode 값을 반환하는 것
        *
        * */

        StringBuilder sb = new StringBuilder(s);
        //System.out.printf("원래 데이터 :: %s ,", s);

        //index 삭제
        if (sb.length() > 3) sb.deleteCharAt(3);
        if (sb.length() > 2) sb.deleteCharAt(2);
        if (sb.length() > 1) sb.deleteCharAt(1);


        //System.out.println("바뀐 데이터 :: " + sb.toString());
        return sb.toString().hashCode();
    };
    static StringProcessor2 process2 = s -> {
        int sleng = s.length();
        //System.out.println("처음 sleng :: "+ sleng);

        if (sleng >= 4) {
          //  System.out.println("4이상 데이터 :: "+ process1.process(s) + sleng);
            return process1.process(s) + sleng;
        }
        else {
            //System.out.println("문자열 길이 3 이하 :: "+ s);
            //System.out.print("3이하 데이터 :: ");
            //System.out.println(s.hashCode() - sleng);
            return s.hashCode() - sleng;
        }
    };

    public static void main(String[] args) {

        String[] strArray = {"apple", "Banana", "Cherry", "date", "Egg", "fig", "Grape", "honey", "ice", "Jack"};


        UpperManipulator upperManipulator = new UpperManipulator(strArray);
        int maniUpper = upperManipulator.manipulate();


        LowerManipulator lowerManipulator = new LowerManipulator(strArray);
        int maniLower = lowerManipulator.manipulate();


        long sum = 0;
        for (String s : strArray) {
            sum += process2.process(s);
            //System.out.println("process2 거친 애들 "  + process2.process(s));
        }

        long result = (long)maniUpper + maniLower + sum;


        System.out.println(result);
    }
}