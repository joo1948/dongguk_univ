package Practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

interface Calculator{
    int calculate(int a, int b);
}

public class lmbda {
    public static void main(String[] args){
        Calculator addition = (a,b) -> a+b;

        Calculator subtraction = (a,b)->{
            return a-b;
        };

        int x= 10;
        int y = 5;

        int sum = addition.calculate(x,y);
        int difference = subtraction.calculate(x,y);

        System.out.println(sum);
        System.out.println(difference);

        Consumer<String> printer = (message) ->{
            System.out.println("메세지 : "+ message);
        };

        printer.accept("Hello, Lambda!");

        //
         //Predicate :: 조건검사
        Predicate<String> isLongerThanTen = (s) ->s.length() > 19;

        String shortString= "Java";
        String longString = "FunctionlInterface";

        System.out.println("'" + shortString + "'은 긴 문자열인가 ? "+ isLongerThanTen.test(shortString));
        System.out.println("'" + longString + "'은 긴 문자열인가 ? "+ isLongerThanTen.test(longString));

        Predicate<Integer> isEven = n -> n%2 == 0;
        Predicate<Integer> isPositive = n->n>0;

        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);

        System.out.println("12는 짝수이면서 홀수인가? :" + isEvenAndPositive.test(12));

        //
         //Consumer :: 값 소비

        Consumer<String> upperCasePrinter = s->System.out.println(s.toUpperCase());

        upperCasePrinter.accept("hello lambda");

        List<Integer> numbers = Arrays.asList(1,2,3,4);

        System.out.println("리스트 요소 출력 : ");
        numbers.forEach(n->System.out.println(n*2 + " "));
        System.out.println();//해당 부분은 관련 없는거 아닌가 ?

        //
        //Function 타입변환
        Function<String, Integer> stringLength = s->s.length();
        int length = stringLength.apply("Functional Programming");
        System.out.println("문자열 길이 : " + length);

        Function<Integer, String> numberToString = i -> "Value is" + i;
        String result = numberToString.apply(123);
        System.out.println(result);

        System.out.println();

        //
        //Supplier :: 값 공급
        Supplier<LocalDateTime> nowSupplier = () -> LocalDateTime.now();

        LocalDateTime now = nowSupplier.get();
        System.out.println("현재 시간 공급 : "+ now);

        Supplier<Double> randomNumberSupplier = () -> Math.random() * 100;

        System.out.println("무작위 숫자 " + randomNumberSupplier.get());


        Function<String, Integer> calculateValue = (s)-> s.length()*5 ;
        System.out.println(calculateValue.apply("Lambda"));

        List<Integer> num = Arrays.asList(1,2,3,4);
        num.forEach(n -> System.out.println(n+10));

        int num2 = 75;
        Predicate<Integer> isGreaterOrEqual50 = n-> n>= 50;

        Predicate<Integer> isLessThan100 = n-> n<100;

        Predicate<Integer> finalCheck = isGreaterOrEqual50.and(isLessThan100);

        boolean result2 = finalCheck.test(num2);
        System.out.println(num2 + "은 50 이상, 100 미만인가 ? :: "+ result2);


        Supplier<Long> timeSupplier = () -> System.currentTimeMillis();
        System.out.println("현재시간 (밀리초)" + timeSupplier.get());
    }

}
