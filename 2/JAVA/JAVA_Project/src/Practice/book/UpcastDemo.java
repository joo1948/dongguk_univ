package Practice.book;

class Person2
{
    String name = "사람";

    void whoami(){
        System.out.println("나는 사람읻.");
    }

}

class Child2 extends Person2{
    int number = 7;

    void work(){ System.out.println("나느 공부한다.");}

}
public class UpcastDemo {
    public static void main(String[] args){

        Person2 p2;
        Child2 child2 = new Child2();

        p2 = child2;
        

        child2.name = " test" ;
        child2.whoami();
        child2.number = 123;

        //강제형변환

        Child2 cc = (Child2)p2;
        cc.whoami();
        cc.name="test";






    }
}
