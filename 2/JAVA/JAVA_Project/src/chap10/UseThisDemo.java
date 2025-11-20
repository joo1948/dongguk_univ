package chap10;

interface UseThis { void use();}

public class UseThisDemo {
    public void lambda() {
        String hi = "Hi";

        UseThis u1 = new UseThis(){ // 익명 지역 객체
            public void use(){
                System.out.println(this);
            }
            // 지역 객체의 this는 지역 객체 '자신' 을 참조한다.
            // 따라서 this는 UseThis의 자식인 익명 객체이다
            //hi = "Lambda." ; //> 지역 객체에서 사용되는 외부 지역 변수는 실질적으로 final이다. 따라서 변경될 수 없다.
        };
        u1.use();

        UseThis u2 = () -> {//람다식
            System.out.println(this); //람다식의 this는 Usethis의 자식 익명 객체가 아닌, 외부 객체를 의미하기 때문에,
            //람다식의 this는 람다식을 사용하는 UseThisDemo 객체를 의미한다.
            //hi = "Lambda"; //>람다식에서도 사용되는 외부 지역변수도 실질적 final이기 때문에 변경될 수 없다.

        };
        u2.use();

    }
    public String toString(){
        return "UseThisDemo";
    }

    public static void main(String[] args){
        int one = 1;

        new UseThisDemo().lambda();
        //Comparator<String> c = (one, two) -> one.length() - two.length();
        //  > 여기서 one을 사용 못하는데, 이유는 람다식의 선언부에서 외부에서 선언된 동일한 이름의 변수를 선언할 수 없다.
    }
}
