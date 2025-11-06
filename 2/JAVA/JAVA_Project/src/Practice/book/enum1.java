package Practice.book;

public class enum1 {
    public static void main(String[] args){
        Gender gender = Gender.FEMALE;

        if(gender == Gender.FEMALE){
            System.out.println(gender + "병역의 으무 없음");
        }else {
            System.out.println(gender + "병역 의무 있음");
        }

        //ekfms

    }
}

enum Gender{ MALE , FEMALE }
enum Direction {EAST, WEST, SOUTH, NORTH}
