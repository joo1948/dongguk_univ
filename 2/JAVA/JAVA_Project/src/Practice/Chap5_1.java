package Practice;

public class Chap5_1 {
    public static void main(String[] args){

    }

    static int countChar(String s, char c){
        int r = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                r++;
            }
        }

        return r;
    }
}
