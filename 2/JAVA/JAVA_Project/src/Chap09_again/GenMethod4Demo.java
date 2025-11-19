package Chap09_again;

class Ticket2 implements Comparable<Ticket2>{
    //GenMethod3Demo에서 노란줄이 뜨는 이유
    //원래 Comparable은 제네릭 클래스이기 때문에 타입 명시 해줘야함. 
    //근데 GenMethod3Demo에서는 Raw타입마냥 사용해버림
    //그래서 GenMethod4Demo에서는 타입 명시해준 것임
    int no;

    public Ticket2(int no){
        this.no = no;
    }

    public int compareTo(Ticket2 o){
        Ticket2 t = (Ticket2) o;
        return no < t.no ? -1 : (no>t.no ? 1: 0);
    }
}

public class GenMethod4Demo{
    public static <T extends Comparable<Ticket2>> int countGT(T[] a, T elem){
        int count = 0;
        for(T e : a){
            if(e.compareTo((Ticket2)elem)> 0) ++count;
        }
        return count;
    }

    public static void main(String[] args){
        Ticket2[] a = {new Ticket2(5), new Ticket2(3), new Ticket2(10), new Ticket2(7), new Ticket2(4)};

        System.out.println(countGT(a, a[4])); //Comparable 자식들만 적용 가능
    }
}