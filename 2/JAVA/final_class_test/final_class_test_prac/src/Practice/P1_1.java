package Practice;

abstract class Animal{
    private String name;
    abstract void act();
}


interface Soundable{
    void sound();
}

class Dog extends Animal implements Soundable{
    void act(){
        System.out.println("뛰어다닌다.");
    }

    public void sound() {
        System.out.println("멍멍");
    }
}
class Cat extends Animal implements Soundable{
    void act(){
        System.out.println("기어간다.");
    }

    public void sound(){
        System.out.println("야옹");
    }
}
class Bird extends Animal  implements Soundable{
    void act() {
        System.out.println("난다");
    }

    public void sound(){
        System.out.println("짹짹");
    }
}

public class P1{
    public static void main(String[] args){
        Animal[] animal = {new Dog(), new Cat(), new Bird()};

        //(Soundable)a[0].sound();//⭐
        //((Soundable)animal[0]).sound(); >> 이렇게 써야함.
        for(Animal a : animal){
            a.act();
            ((Soundable)a).sound();
        }
    }
}


