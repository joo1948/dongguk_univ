package Test1;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int total = 0;

        int arr[] = new int[num];

        for(int i=0;i<arr.length;i++){
            arr[i] = in.nextInt();

        }
        //System.out.println(arr.length);
        if(arr.length>=3){
            for(int i=2;i<arr.length;i++) {
                if (arr[i - 2] >= 5 && arr[i-1] >= 5 && arr[i] >= 5){
                    arr[i-2] = 0;
                    arr[i-1] = 0;
                    arr[i] = 0;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            total += arr[i];
        }

        System.out.println(total);
    }
}
