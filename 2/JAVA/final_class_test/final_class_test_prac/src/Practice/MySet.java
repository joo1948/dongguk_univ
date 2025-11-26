package week11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<T> implements Set<T> {

    // Set의 원소를 저장할 내부 리스트
    private final ArrayList<T> elements = new ArrayList<>();

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        // 특정 원소의 포함 여부를 리턴한다.
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public boolean add(T t) {
        // 원소를 추가한다. 중복이면 추가하지 않고 false를 리턴한다.
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean remove(Object o) {
        // 특정 원소를 제거하고, 제거에 성공했는지 리턴한다.
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void clear() {
        // 모든 원소를 제거한다.
        throw new UnsupportedOperationException("TODO");
    }
    
    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return elements.toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // 이 Set이 주어진 Collection의 모든 원소를 포함하는지 확인한다. (부분 집합 확인)
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // 주어진 Collection의 모든 원소를 이 Set에 추가한다. (합집합 연산)
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // 이 Set에서 주어진 Collection에 포함되지 않은 원소들을 모두 제거한다. (교집합 연산)
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // 이 Set에서 주어진 Collection에 포함된 모든 원소를 제거한다. (차집합 연산)
        throw new UnsupportedOperationException("TODO");
    }
}