package ru.onehalf.algorithms;

import java.util.*;

/**
 * Set на основе массива.
 * Сделан для начальных реализачий коллекций, чтобы не использовать стандартный CollectionFramework
 *
 * Все операции работают за линейное время. Не используйте в продакшене!
 *
 * Date: 06.11.2017
 * @author OneHalf
 */
public class SimpleSet<E> implements Set<E> {

    @SafeVarargs
    public static <E> SimpleSet<E> of(E... array) {
        return new SimpleSet<>(array);
    }

    private final Object[] array;

    public SimpleSet() {
        this((E[])new Object[0]);
    }

    @SafeVarargs
    private SimpleSet(E... values) {
        Object[] array = values.clone();
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (Objects.equals(array[i], array[j])) {
                    array[j] = array[size - 1];
                    j--;
                    size--;
                }

            }
        }
        if (size != array.length) {
            array = Arrays.copyOf(array, size);
        }
        this.array = array;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = -1;

            @Override
            public boolean hasNext() {
                return currentIndex < size() - 1;
            }

            @Override
            public E next() {
                return (E) array[++currentIndex];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size(), array.getClass());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(array, size(), a.getClass());
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : array) {
            if (Objects.equals(element, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("attempt to change immutable set");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("attempt to change immutable set");
    }


    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("attempt to change immutable set");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("attempt to change immutable set");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("attempt to change immutable set");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("attempt to change immutable set");
    }
}
