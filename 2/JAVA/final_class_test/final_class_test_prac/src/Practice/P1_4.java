package Practice;

class InvalidScoreException extends Exception{
    public InvalidScoreException(String msg) throws InvalidScoreException{
        super(msg);
    }
}
abstract class Student{
    String name;
    int score;

    //⭐super 쓸 생성자 생성
    Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    abstract void evaluate();
}
interface Gradable{
    char getGrade() throws InvalidScoreException;
}

class Undergraduate extends Student implements Gradable{
    //⭐super사용해야함
    Undergraduate(String name, int score){
        super(name, score);
    }

    public void evaluate(){
        System.out.printf("학생[%s]의 점수는[%d]입니다.\n", this.name, this.score);
    }

    public char getGrade() throws InvalidScoreException{
        char grade_r = 'F';
        if(this.score > 100 || this.score < 0){
            throw new InvalidScoreException("유효하지 않은 점수입니다.");
        }else{
            if(score>=90 && score <= 100) grade_r = 'A';
            if(score>=80 ) grade_r = 'B';
            if(score>=70 ) grade_r = 'C';
            if(score>=60 ) grade_r = 'D';
            else System.out.println("F");
        }
        return grade_r;
    }
}

class Graduate extends Student implements Gradable{

    //원래 썼던 것⭐
    /*public Graduate(String name, int score){
        this.name = name;
        this.score = score;
    }*/
    Graduate(String name, int score){
        super(name, score);
    }

    public void evaluate(){
        System.out.printf("학생[%s]의 점수는[%d]입니다.\n", this.name, this.score);
    }

    public char getGrade() throws InvalidScoreException{
        char grade_r='F';
        if(this.score > 100 || this.score<0) {
            throw new InvalidScoreException("유효하지 않은 점수입니다.");
        }else{
            if(score>=90 && score <= 100) grade_r = 'A';
            if(score>=80 ) grade_r = 'B';
            if(score>=70 ) grade_r = 'C';
            if(score>=60 ) grade_r = 'D';
            else System.out.println("F");
        }
        return grade_r;
    }
}

public class P4 {
    public static void main(String[] args){
        Student[] students = {new Undergraduate("강주똥", -9)
                                ,new Graduate("강주영", 90)};

        for(Student s : students){
            try{
                s.evaluate();
                char grade = ((Gradable)s).getGrade();
                System.out.println("점수 성적 :: " + grade);
            }catch(InvalidScoreException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
