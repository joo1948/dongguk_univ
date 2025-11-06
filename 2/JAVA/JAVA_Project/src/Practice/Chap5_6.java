package Practice;

public class Chap5_6 {
    public static void main(String[] args){

        int[] org = {1,2,3,4,5,6,7,8,9};
        int len = org.length;

        int[] print_org = new int[len];
        print_org = reverse(org);

        for(int i=0;i<len;i++){
            System.out.print(print_org[i] +" ");
        }
        System.out.println();


    }
    public static int[] reverse(int[] org){
        int len = org.length;

        int arr[] = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = org[len-1-i];
        }

        return arr;
    }
}
