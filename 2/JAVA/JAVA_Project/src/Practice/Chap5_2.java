package Practice;

public class Chap5_2 {
    public static void main(String[] args){
        System.out.println(sumExceptFirst(1,2,3,4));
        int arr[] = {2,3};
        System.out.println(sumExceptFirst(1, arr));
        System.out.println(sumExceptFirst(1,2,3,4,5));

    }

    static int sumExceptFirst(int start, int ... v){
        int total = 0;
        for(int i : v){
            total += i;
        }
        return total;
    }

}
