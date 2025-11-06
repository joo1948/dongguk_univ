package Test2;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args){
        Scanner in = new java.util.Scanner(System.in);

        String[] arr = in.nextLine().split(" ");


        for(int i=0;i<arr.length; i++){
            String temp = arr[i];
            int cnt =0;
            for(int j=0;j<arr.length;j++){
                if(temp.toLowerCase().equals(arr[j].toLowerCase())) cnt++;
            }

        }


    }
}
