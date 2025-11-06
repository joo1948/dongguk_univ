package Practice.book;

public class enum2 {
    public static void main(String[] args){
        Gender2 gender = Gender2.MALE;
        if(gender == Gender2.MALE){
            System.out.println(Gender2.MALE + "은 병역의무 해햐한다.");
        }else{
            System.out.println(Gender.FEMALE + "은 병역의무 할 필요 없다.");
        }

        for(Gender2 g: gender.values()){
            System.out.println(g.name());
        }

        System.out.println(Gender2.valueOf("MALE"));

    }
}
enum Gender2 {
    MALE("남성"), FEMALE("여성");

    private String s; // 불변으로 만들어주는 게 좋음

    Gender2(String s) { // 생성자
        this.s = s;
    }

    String get() {
        return this.s;
    }
}

