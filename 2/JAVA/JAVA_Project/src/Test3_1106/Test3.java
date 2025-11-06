package Test3_1106;

import java.util.Random;

class RepairFailException extends Exception{
    public RepairFailException(String msg) { super(msg);}

}

abstract class Vehicle{
    abstract void drive();
    abstract void inspect();
}

interface Repairable{
    public void repair() throws RepairFailException;
}

class Car extends Vehicle implements Repairable{
    void drive(){
        System.out.println("자동차가 달립니다.");
    }
    void inspect(){
     System.out.println("정상");
    }
    public void repair() throws RepairFailException{
        Random random = new Random();

        int r = random.nextInt(100);
        if(r < 20){
            throw new RepairFailException("수리가 실패했습니다.");
        }
        else inspect();
    }
}

class Bus extends Vehicle implements Repairable{
    void drive(){
        System.out.println("버스가 달립니다.");
    }
    void inspect(){
        System.out.println("정상");
    }
    public void repair() throws RepairFailException{
        Random random = new Random();

        int r = random.nextInt(100);
        if(r < 20){
            throw new RepairFailException("수리가 실패했습니다.");
        }
        else inspect();
    }
}

class Motorcyle extends Vehicle implements Repairable{
    void drive(){
        System.out.println("오토바이가 달립니다.");
    }
    void inspect(){
        System.out.println("정상");
    }
    public void repair() throws RepairFailException{
        Random random = new Random();

        int r = random.nextInt(100);
        if(r < 20){
            throw new RepairFailException("수리가 실패했습니다.");
        }
        else inspect();
    }
}

public class Test3 {
    public static void main(String[] args){
        Vehicle[] v= {new Car(), new Bus(), new Motorcyle()};

        for(Vehicle vi : v){
            vi.drive();;
            vi.inspect();
            try {
                ((Repairable) vi).repair();
            }catch(RepairFailException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
