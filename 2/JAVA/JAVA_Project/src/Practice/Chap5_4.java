package Practice;

import java.util.Scanner;

public class Chap5_4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String s ="";


        while(true) {
            System.out.print("URL을 입력하세요 : ");
            s = in.nextLine();
            if(s.equals("bye")) break;
            if (s.endsWith("com")) {
                System.out.println(s + "은 'com'으로 끝납니다.");
            } else {
                System.out.println(s + "은 'com'으로 끝나지 않습니다.");
            }

            if (s.contains("java")) {
                System.out.println(s + "은 'java'를 포함합니다.");
            } else {
                System.out.println(s + "은 'java'를 포함하지 않습니다.");
            }
        }

    }
}
