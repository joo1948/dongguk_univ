package Chap09_again;

import java.util.ArrayList;

public class GenericInheritanceDemo {
    public static void main(String[] args){
        ArrayList<Beverage> list1 = new ArrayList<>();
        list1.add(new Beer());
        beverageTest(list1);//ArrayList<Beverage>를 매개변수로 받고 있는데, ArrayLIst<Beverage>의 list를 넣고 있으니, 같은 객체 취급 하여 동작 가능


        ArrayList<Beer> list2 = new ArrayList<>();
        list2.add(new Beer());
        //beverageTest(list2);//ArrayList<Beverage>자식이 ArrayList<Beer>가 아니기 때문에 사용 불가능
        //그냥 Beverage 와 Beer 가 아닌, ArrayList<Beverage>와 ArrayList<Beer>인 점을 주의
    }
    static public void beverageTest(ArrayList<Beverage> list){}
}
