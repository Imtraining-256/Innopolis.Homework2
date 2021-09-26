package lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BicycleLinkedList<E> implements List<E> {

    ListItem<E> first;
    ListItem<E> last;

    transient int size = 0;

    BicycleLinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        final ListItem<E> l = last;
        final ListItem<E> newItem = new ListItem<>(l, e, null);
        last = newItem;

        if (l != null) {
            l.next = newItem;
        } else {
            first = newItem;
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return listItem(index).item;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    private void checkIndex(int index) {
        boolean isIndexExist = index >= 0 && index < size;
        if (!isIndexExist) {
            throw new IndexOutOfBoundsException();
        }
    }

    private ListItem<E> listItem(int index) {
        ListItem<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public E remove(int index) {

        checkIndex(index);

        var x = listItem(index);

        final E element = x.item;
        final ListItem<E> next = x.next;
        final ListItem<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;

        return element;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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

    private class ListItem<T> {

        T item;

        ListItem<T> prev;
        ListItem<T> next;

        public ListItem(ListItem<T> prev, T item, ListItem<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}


