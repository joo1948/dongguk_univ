package Practice.book;

class Person{
    String name = "사람";
    void whoami(){
        System.out.println("나는 사람이다.");
    }
}

class Child extends Person{
    int number = 7 ;
    void work() {
        System.out.println("나는 공부한다.") ;
    }

    void whoami(){
        System.out.println("나는 아이다.");
    }
}


public class chap6_18 {
    public static void main(String[] args){
        //자동 형변환
        Person p;
        Child s = new Child();

        p=s;
        p.whoami();//나는 아이다 >> 부모가 자식 객체를 참조하고 있음
        s.whoami();
    }
}
