package Chap09;

import java.util.Scanner;

public class p3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            int n = sc.nextInt();
            checkScore(n);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

     static void checkScore(int score) {
        if(score<0 || score >100) {
            throw new IllegalArgumentException("점수는 0이상 100이하만 가능합니다.");
        }else{
        System.out.println(score);

        }
    }
}
