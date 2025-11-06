package Test3_1106;

abstract class Animal{
    String name;
    abstract void act();
}

interface Soundable {
    void sound();
}
class Dog extends Animal implements Soundable{
    void act(){
        System.out.println("뛰어다닌다.");
    }

   public void sound(){
        System.out.println("멍멍");
    }
}

class Cat extends Animal implements Soundable{
    void act(){
        System.out.println("기어간다.");
    }

    public void sound() {
        System.out.println("야옹");
    }
}
class Bird extends Animal implements Soundable{
    void act(){
        System.out.println("난다");
    }
    public void sound(){
        System.out.println("짹짹");
    }
}
public class Test1 {
    public static void main(String[] args){
        Animal[] animal = {new Dog(), new Cat(), new Bird()};

        for(Animal a : animal){
            a.act();
            ((Soundable)a).sound();
        }
    }
}
