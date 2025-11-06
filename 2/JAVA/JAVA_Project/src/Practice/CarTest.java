package Practice;

class Car {
    String color;
    static int r_cnt;
    static int count;

    Car(String color){
        count++;
        if(color.equalsIgnoreCase("red")) r_cnt++;
    }

    public static int getNumOfCar(){
        return count;
    }

    public static int getNumOfRedCar(){
        return r_cnt;
    }


}

public class CarTest {
    public static void main(String[] args){
        Car c1 = new Car("red");
        Car c2 = new Car("blue");
        Car c3 = new Car("RED");

        System.out.printf("자동차 수 : %d, 빨간색 자동차 수 : %d\n", Car.getNumOfCar(), Car.getNumOfRedCar());

    }
}
