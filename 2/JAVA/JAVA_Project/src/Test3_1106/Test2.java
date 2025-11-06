package Test3_1106;

enum Season {SPRING, SUMMER, FALL, WINTER, NULL};

class InvalidSeasonException extends Exception{
    public InvalidSeasonException(String msg){
        super(msg);
    }

}

class WeatherAdvisor {
    void suggert(Season s) throws InvalidSeasonException{
        if(s == Season.NULL){ throw new InvalidSeasonException("계저를 선택해야합니다.");}

        switch(s){
            case SPRING -> System.out.println("꽃구경 가세요");
            case SUMMER -> System.out.println("시원한 곳으로 피서를 가세요");
            case FALL -> System.out.println("단풍놀이를 가세요");
            case WINTER -> System.out.println("따뜻하게 입으세요");
        }

    }
}

public class Test2{
    public static void main(String[] args){
        WeatherAdvisor wa = new WeatherAdvisor();
        for(Season se : Season.values()){
            try{
                wa.suggert(se);
            }catch(InvalidSeasonException e){
                System.out.println(e.getMessage());
            }
        }
        try{
            wa.suggert(null);
        }catch(InvalidSeasonException ex){
            System.out.println(ex.getMessage());
        }
    }
}