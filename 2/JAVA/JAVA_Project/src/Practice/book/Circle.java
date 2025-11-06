package Practice.book;

class Circle {

    private String test = "test";
    protected String test2 = "Test2;";

    private void secret(){
        System.out.println("비밀이다.");
    }

    protected void findRadius(){
        System.out.println("반지름이 10.0이다.");
    }

    public void findArea(){
        System.out.println("넓이는 파이 * r * r 이다.");
    }
}


class Ball extends Circle{
    private String color;

    public Ball(String color){
        super();
        this.color = color;

    }

    public void findColor(){
        System.out.println(color + "공이다.");
    }

    public void findArea(){//오버라이딩 한거임

        System.out.println("자식의 findArea()");
    }

    public void findVolumne(){
        System.out.println("부피는 4/3 어쩌구 자식 반지름 이다.");
    }
}


