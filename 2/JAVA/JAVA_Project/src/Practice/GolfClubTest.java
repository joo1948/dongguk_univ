package Practice;

class GolfClub {
    int num;
    String name;


    GolfClub(){
        this.num = 7;
        this.name= "아이언";
    }

    GolfClub(int num){
        this.num = num;
        this.name ="아이언";
    }

    GolfClub(String name){
        this.name = name;
    }

    public void print(){
        if(num!=0.0){
            System.out.printf("%d번 %s입니다.\n", num, name);
        }
        else{
            System.out.printf("%s입니다.\n", name);
        }
    }
}


public class GolfClubTest {
    public static void main(String[] args){
        GolfClub g1 = new GolfClub();
        g1.print();

        GolfClub g2 = new GolfClub(8);
        g2.print();

        GolfClub g3 = new GolfClub("퍼터");
        g3.print();
    }
}
