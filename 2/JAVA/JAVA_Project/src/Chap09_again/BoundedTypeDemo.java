package Chap09_again;

public class BoundedTypeDemo {
    public static void main(String[] args){
        Cup2<Beer> c1 = new Cup2<>();//Beer는 Beverage를 상속받고 있으니 가능
        Cup2<Boricha> c2 = new Cup2<>();//Boricha는 Beverage를 상속받고 있으니 가능
        //Cup2<String> c3 = new Cup2<>();//불가능 >> String 은 Beverage를 상속받지 않기 때문




    }
}

class Cup2 <T extends Beverage>{
    //Beverage 타입 혹은 Beverage 자식 타입만 받을 수 있도록 설정
    public T beverage;

    public T getBeverate() { return beverage; }

    public void setBeverage(T beverage){
        this.beverage = beverage;
    }
}
