package Practice;

class Line{
    int line ;
    Line(int line){
        this.line = line;
    }

    public boolean isSameLine(Line l){
        boolean result = false;

        if(l.line == this.line) result = true;

        return result;
    }
}


public class LineTest {
    public static void main(String[] args){
        Line a = new Line(1);
        Line b = new Line(1);

        System.out.println(a.isSameLine(b));
        System.out.println(a==b);//객체판단

    }
}
