package Practice;

public class enumTest_8 {
    public static void main(String[] args) {
        DAY day = DAY.SUN;
        print(day);
        day = DAY.MON;
        print(day);

        int array[] = new int[]{1,2,3,4,5};
    }

    public static void print(DAY d) {

        String s = d.name();
        String result = switch (s) {
            case "SUN", "SAT" -> "최고";
            case "FRI" -> "좋다";
            case "MON" -> "싫다.";
            default -> "그저 그렇다.";
        };

        System.out.println(result);
    }
}

enum DAY{
    SUN("일요일"), MON("월요일"), TUE("화요일"), WED("수요일"), THU("목요일"), FRI("금요일"), SAT("토요일");

    String s;

    DAY(String s){
        this.s = s;
    }

    String get(){
        return this.s;
    }
}
