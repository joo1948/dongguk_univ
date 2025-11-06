package Test3_1106;

class InvalidScoreException extends Exception{
    public InvalidScoreException(String msg) throws InvalidScoreException {super(msg);}
}

abstract class Student{
    String name;
    int score;
    Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    abstract void evaluate();
}

interface Gradable{
    public char getGrade() throws InvalidScoreException;
}

class Undergraduate extends Student implements Gradable{

    Undergraduate(String name, int score){
        super(name, score);
    }

    void evaluate(){
        System.out.println("학생["+name+"]의 점수는 ["+score + "]입니다.");
    }
    public char getGrade() throws InvalidScoreException{
        int s = this.score;
        char result;

        if(this.score <0 || this.score > 100){
            throw new InvalidScoreException("0이하 100초과함!");
        }

        switch(this.score/10){
            case 9, 10 -> result = 'A';
            case 8 -> result = 'B';
            case 7 -> result = 'C';
            case 6 -> result = 'D';
            default -> result = 'F';
        }

        return result;
    }
}

class Graduate extends Student implements Gradable{

    Graduate(String name, int score){
        super(name, score);
    }

    void evaluate(){
        System.out.println("학생["+name+"]의 점수는 ["+score + "]입니다.");
    }
    public char getGrade() throws InvalidScoreException{
        if(score <0 || score > 100){
            throw new InvalidScoreException("0이하 100초과함!");
        }
        if(score >= 90) return 'A';
        if(score >= 80) return 'B';
        if(score >= 70) return 'C';
        if(score >= 60) return 'D';
        return 'F';


    }
}


public class Test4 {
    public static void main(String[] args){
        Student[] stu = {
                new Undergraduate("강강강", 80)
                ,new Graduate("김김김", 40)
                ,new Undergraduate("싱싱싱", -10)
                ,new Graduate("훙훙훙", 70)
        };

        for(Student s : stu){
            s.evaluate();
            try {
                char grade = ((Gradable)s).getGrade();
                System.out.println("학년: " + grade);
            }catch(InvalidScoreException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
