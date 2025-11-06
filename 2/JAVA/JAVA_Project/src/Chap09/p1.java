package Chap09;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int divisor =0;
        try {
            System.out.print("정수 1 입력 : ");
            int n1 = sc.nextInt();
            System.out.print("정수 2 입력 : ");
            int n2 = sc.nextInt();
            divisor = n1/n2;
            System.out.println("출력 : "+ divisor);

        }catch(ArithmeticException e){
            System.out.println("출력 : 0으로 나눌 수 없습니다.");
        }
    }

}
