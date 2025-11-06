package Chap09;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("정수 입력 : ");
            int num = sc.nextInt();
            System.out.println("입력한 수 : " + num);
        }catch(NumberFormatException ex){
            System.out.println("정수가 아닙니다.");
        }finally{
            System.out.println("프로그램을 종료합니다.");
        }


    }
}
