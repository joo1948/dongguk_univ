package Test1;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("학생 수를 입력하세요: ");
        int num = in.nextInt();

        int total=0, max =0, min =0;

        for(int i=1;i<=num;i++){
            System.out.printf("%d번째 학생 점수 : ", i);
            int score = in.nextInt();
            if(i==1){
                min = score;
            }
            if(max < score){
                max = score;
            }
            if(min > score){
                min = score;
            }

            total = total + score;

        }
        double avg = (double)total/(double)num;//평균

        System.out.printf("총점:%d, 평균:%.2f, 최고점: %d, 최저점: %d\n", total, avg, max, min);
    }
}
