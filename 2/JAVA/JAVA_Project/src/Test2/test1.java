package Test2;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("주민등록번호를 입력하세요: ");
        String i = in.next();

        if(i.length() != 14)
            System.out.println("잘못된 주민등록번호 형식입니디ㅏ.");

        String[] arr = i.split("-");

        String birth = arr[0];
        String gender = arr[1];

        String year = birth.substring(0,2);
        if(year.charAt(0)=='1' || year.charAt(0)=='2'){
            year= "19" + year;
        }else{
            year="20"+year;
        }

        String mon = birth.substring(2, 4);
        String day = birth.substring(4,6);

        String gen = arr[1].substring(0,1);
        if(gen.equals("1") || gen.equals("3")){
            gen ="남성";
        }else{
            gen= "여성";
        }

        System.out.println("생년월일: "+ year + "-" + mon + "-" + day );
        System.out.println("성별: "+ gen);


    }
}
