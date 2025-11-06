package Chap07;

public class ControllalbeDemo {
    public static void main(String[] args){
        TV tv = new TV();

        tv.turnOn();
        tv.turnOff();
        tv.repair();

        Controllalbe.reset();
    }
}
