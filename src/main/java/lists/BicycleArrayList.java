package lists;

import java.util.*;

public class BicycleArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    Object[] elementData;

    private int size;

    public BicycleArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }


    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        return new BicycleIterator<>();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length)
            elementData = addSize();
        elementData[size] = e;
        size = size + 1;
        return true;
    }

    private Object[] addSize() {
        int oldSize = elementData.length;
        if (elementData.length > 0) {
            return elementData = Arrays.copyOf(elementData, oldSize * 3 / 2 + 1);
        } else {
            return elementData;
        }
    }

    @Override
    public boolean remove(Object o) {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {

        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {

        Objects.checkIndex(index, size);

        final Object[] es = elementData;

        final int newSize;

        E oldValue = (E) es[index];

        newSize = size - 1;
        if (newSize > index)
            System.arraycopy(es, index + 1, es, index, newSize - index);
        es[size = newSize] = null;

        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    private class BicycleIterator<E> implements Iterator<E> {

        private final E[] objects;
        private int index = 0;

        public BicycleIterator() {
            this.objects = (E[]) elementData;
        }

        @Override
        public boolean hasNext() {
            return index < objects.length;
        }

        @Override
        public E next() {
            return objects[index++];
        }
    }
}