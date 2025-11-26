package Practice;

import java.util.AbstractList;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class MyArrayListImpl2<T> extends AbstractList<T> {

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
    public boolean add(T element) {
        if(array.length == size) {
            Object[] newArray = new Object[size * 2];
            for(int i = 0; i < size; i++) newArray[i] = array[i];
            this.array = newArray;
        }
        this.array[size++] = element;
        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i<size; i++) array[i] = null;
        size = 0;
    }

    @Override
    public void add(int index, T element) {
        if(array.length == size) {
            Object[] newArray = new Object[size * 2];
            for(int i = 0; i < size; i++) newArray[i] = array[i];
            this.array = newArray;
        }
        if(index < 0 || index > size) throw new IllegalArgumentException("wrong index");
        for(int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        size++;
        array[index] = element;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("wrong index");

        T removedElement = (T) array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }

        array[--size] = null;
        return removedElement;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        for (int i = 1; i < size; i++) {
            T key = (T) array[i];
            int j = i - 1;
            while (j >= 0 && c.compare((T) array[j], key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}