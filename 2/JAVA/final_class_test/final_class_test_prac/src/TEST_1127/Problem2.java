package TEST_1127;

import java.util.Arrays;

interface StringProcessor {
    int process(String s);

    StringProcessor process1 = s -> {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return s.length() * -2;
        }
    };


    StringProcessor process2 = s -> {
        try {
            Integer.parseInt(s);
            return process1.process(s) / 3;
        } catch (NumberFormatException e) {
            return process1.process(s) + s.length();
        }
    };
}

/*
* 문자열 s가 정수로 변환 가능한 경우
→ process1(s)의 반환값을 3으로 나눈 몫(정수 나눗셈) 반환.
문자열 s가 정수 변환이 불가능한 경우
→ process1(s)의 반환값에 문자열 길이를 더한 값을 반환
*
* >>>> total 직접 계산하고 result랑 total도 찍어서 확인하기
* p.780에 작성
* */

public class Problem2 {
    public static void main(String[] args) {

        String[] data = {"12", "xyz", "1000" , "abc" , "7", "12345", "4A", "AB3", "QQ"};

        int total = 0;

        for (String s : data) {
            int result = StringProcessor.process2.process(s);
            //System.out.println(result + "    ");
            total += result;
            //System.out.println("total :: "+ total);
        }
        System.out.println(total);
    }
}