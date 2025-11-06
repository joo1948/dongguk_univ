package Practice;

public class Chap5_7 {
    public static void main(String[] args){
        int[] a={3,2,4,1,5};
        int[] b= {3,2,4,1};
        int[] c = {3,2,4,1,5};
        int[] d = {2,7,1,8,2};

       check_content(a,b);
       check_content(a,c);
       check_content(c,d);

    }


    public static void check_content(int[] a, int[] b){

        int r = 1;
        if(a.length != b.length) r = -1;
        else {
            for(int i=0;i<a.length;i++){
                if(a[i] != b[i]) r= -1;
            }
        }
        if(r==1) System.out.println("똑같음");
        else System.out.println("다름");
    }
}
