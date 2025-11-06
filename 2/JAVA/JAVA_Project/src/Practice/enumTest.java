package Practice;

import java.util.Scanner;

public class enumTest {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String day_in = sc.nextLine();
        Day d ;
        switch(day_in){
            case "MON" -> d= Day.MON;
            case "Thu" -> d=Day.THU;
            case "SUN" -> d=Day.SUN;
        };






    }
}
enum Day{
    SUN,MON,THU,WED,THR, FRI, SAT
}