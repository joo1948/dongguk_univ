package Chap09_again;

public class Entry <K,V>{

    private K key;
    private V value;
    //K와 V에 무슨 값이 들어와도 사용 가능

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }
    public V getValue() {
        return value;
    }
}
