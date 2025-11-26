package Practice;

import java.util.*;

abstract class Vehicle{
    abstract void drive();
    abstract void inspect();
}

interface Repairable {
    void repair() throws RepairFailException;
}

class RepairFailException extends Exception{
    public RepairFailException(String msg) throws RepairFailException{
        super(msg);
    }
}

class Car extends Vehicle implements Repairable{
    Random r = new Random();
    int num = r.nextInt(5);

    void drive(){
     System.out.println("자동차가 달립니다.");
    }
    void inspect(){
        System.out.println("정상입니다.");
    }
    public void repair() throws RepairFailException{
        if(num ==0){
            throw new RepairFailException("자동차 수리가 실패했습니다.");
        }
        System.out.println("자동차 수리 성공했습니다.");
    }
}
class Bus extends Vehicle implements Repairable{
    Random r = new Random();
    int num = r.nextInt(5);

    public void drive(){
        System.out.println("버스가 달립니다.");
    }
    public void inspect(){
        System.out.println("정상입니다.");
    }
    public void repair() throws RepairFailException{
       if(num ==0) {
           throw new RepairFailException("버스 수리가 실패했습니다.");
       }else{
           System.out.println("버스 수리가 성공했습니다.");
       }
    }
}
class Motorcycle extends Vehicle implements Repairable{
    Random r = new Random();
    int num = r.nextInt(5);

    public void drive(){
        System.out.println("오토바이가 달립니다.");
    }
    public void inspect(){
        System.out.println("정상입니다.");
    }
    public void repair() throws RepairFailException{
        if(num == 0) {
            throw new RepairFailException("오토바이 수리 실패했습니다.");
        }else{
            System.out.println("오토바이 수리 성공했습니다.");
        }
    }
}

public class P3 {
    public static void main(String[] args){
        Vehicle[] vehicle = {
                new Car(), new Bus(), new Motorcycle()
        };
        for(Vehicle v : vehicle){
            try {
                v.drive();
                v.inspect();
                ((Repairable) v).repair();
            }catch(RepairFailException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
