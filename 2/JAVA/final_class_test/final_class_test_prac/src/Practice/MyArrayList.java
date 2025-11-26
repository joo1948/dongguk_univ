package week11;

import java.util.AbstractList;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class MyArrayList<T> extends AbstractList<T> {

    private Object[] array = new Object[10];
    private int size = 0;

    @Override
    public T get(int index) {
        boolean isValidIndex = 0 <= index && index < size;
        if(!isValidIndex) throw new IllegalArgumentException("wrong index");
        return (T) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T value) {
        // 마지막 인덱스에 원소 추가
        throw new IllegalStateException("TODO");
    }

    @Override
    public T remove(int index) {
        // 특정 인덱스의 원소 제거
        throw new IllegalStateException("TODO");
    }

    @Override
    public boolean contains(Object o) {
        // 리스트의 특정 원소 포함 여부 리턴
        throw new IllegalStateException("TODO");
    }

    @Override
    public int indexOf(Object o) {
        // 특정 원소의 인덱스 리턴. 원소가 존재하지 않을 경우 -1 리턴.
        throw new IllegalStateException("TODO");
    }

    @Override
    public void sort(Comparator<? super T> c) {
        // 주어진 Comparator를 이용해 원소 오름차순 정렬
        throw new IllegalStateException("TODO");
    }

    @Override
    public void clear() {
        // 모든 원소 제거
        for(int i = 0; i<size; i++) array[i] = null;
        size = 0;
    }

    @Override
    public void add(int index, T element) {
        // 특정 index에 원소 삽입
        throw new IllegalStateException("TODO");
    }
}
