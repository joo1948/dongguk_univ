package Test1;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("출력할 단을 입력하세요: ");
        int num = in.nextInt();

        for(int i=1;i<=9;i++){
            System.out.printf("%d * %d = %d\n", num, i, num*i);
        }
    }
}
