package Practice;

enum Season{SPRING, SUMMER, FALL, WINTER};

class InvalidSeasonException extends Exception{
    public InvalidSeasonException(String msg) throws InvalidSeasonException{
        super(msg);
    }
}

class WeatherAdvisor{
    void suggest(Season s) throws InvalidSeasonException{
        if(s == null) {
            throw new InvalidSeasonException("계절을 선택해야합니다.");
        }
        switch(s){
            case SPRING: System.out.println("꽃구경 가세요"); break;
            case SUMMER: System.out.println("시원한 곳으로 피서를 가세요"); break;
            case FALL: System.out.println("단풍놀이를 가세요"); break;
            case WINTER: System.out.println("따뜻하게 입으세요"); break;
        }
    }
}
public class P2 {
    public static void main(String[] args) throws InvalidSeasonException {
        WeatherAdvisor w = new WeatherAdvisor();
        //⭐
        for(Season s: Season.values()){
            try{
                w.suggest(s);
            }catch(InvalidSeasonException e){
                System.out.println(e.getMessage());
            }
        }
        try{
            w.suggest(null);
        }catch(InvalidSeasonException e){
            System.out.println(e.getMessage());
        }
    }
}
