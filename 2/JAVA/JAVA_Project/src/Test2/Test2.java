package Test2;


import java.util.Scanner;

class Person {
    private void secret() { System.out.println("부모 비밀"); }
}

class Student extends Person {
    private void secret() { System.out.println("자식 비밀"); }
}

public class Test2 {
    public static void main(String[] args){

        int[][] array = {{1,2},{1}, {3,4,5}};
        for(int[] i : array){
            System.out.println(i.length);
        }

    }
}
