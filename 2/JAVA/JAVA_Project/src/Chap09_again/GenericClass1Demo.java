package Chap09_again;
import Chap09_again.Cup;

public class GenericClass1Demo {
    public static void main(String[] args){
        Cup c = new Cup();

        c.setBeverage(new Beer());
        Beer b1 = (Beer) c.getBeverage();

        c.setBeverage(new Boricha());
        Boricha b2 = (Boricha)c.getBeverage();//
    }
}
