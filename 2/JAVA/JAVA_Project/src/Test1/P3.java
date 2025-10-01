package Test1;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int c_n = in.nextInt();//통화의 개수
        int a_total=0;
        int b_total=0;

        for(int i=0;i<c_n;i++){
            int t_n = in.nextInt();//통화 시간
            int t_n_a= t_n;
            int t_n_b = t_n;
            //A구간 연산
            int temp=0;
            if(t_n_a <= 29) a_total += 10;
            else if(t_n_a >= 30 && t_n_a <= 59) a_total += 20;
            else{
                //6s0 이상인 경우
                //일단 60 넘겼으니 + 20
                a_total += 10;
                //60 - 59 값을 가지고 if, elseif 연산 또하기
                while(true){
                    t_n_a -= 29;
                    if(t_n_a <= 29) {a_total+=10; break;}
                    else if(t_n_a >= 30 && t_n_a <= 59) {a_total += 20; break;}
                    else a_total+=10;
                }
            }
            //System.out.println("중간중간 A :: " + a_total);
            //B구간 연산
            int temp_b=0;
            if(t_n_b <= 59) b_total += 15;
            else if(t_n_b >= 60 && t_n_b <= 119) b_total += 30;
            else{
                //119이상
                //일단 60 넘겼으니 + 20
                b_total += 15;
                //60 - 59 값을 가지고 if, elseif 연산 또하기
                while(true){
                    t_n_b -= 59;
                    if(t_n_b <= 59) {b_total+=15; break;}
                    else if(t_n_b >= 60 && t_n_b <= 119) {b_total += 30; break;}
                    else b_total+=15;
                }
            }
            //System.out.println("중간중간 B :: " + b_total);

            //A, B 비교

        }

        if(a_total > b_total) System.out.println("B "+ b_total);
        else if(a_total < b_total) System.out.println("A "+ a_total);
        else if(a_total == b_total) System.out.println("A B " + a_total);
        //System.out.printf("A :: %d\n", a_total);
        //System.out.println("B :: " + b_total);

    }
}
