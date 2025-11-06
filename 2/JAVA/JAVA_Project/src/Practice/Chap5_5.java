package Practice;

import java.util.Scanner;

public class Chap5_5 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] org = new int[10];

        int length = org.length;
        for(int i=0;i<10;i++) org[i] = 0;

        System.out.println("숫자를 입력하세요.");
        for (int i=0;i<10;i++){
            int num = sc.nextInt();
            if(num <0 || num > 99) continue;
            int index = num/10;
            org[index]++;
        }

        for(int i=0;i<9;i++){
            if(i==0) System.out.print("0~9 : ");
            else System.out.print(i+"0~" + i +"9: ");
            for(int j=0; j<org[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
