package Chap09_again;

public class Cup<T>{
    private T beverage;//어떤 객체가 와도 사용 가능


    public T getBeverage(){
        return beverage;
    }
    public void setBeverage(T beer){
        this.beverage = beverage;
    }

}
