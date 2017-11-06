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

    /**
     * Create a Set from unique values.
     * For optimisation, it doesn't check uniqueness of values.
     *
     * @param iterable values for Set
     * @param <E> elements type
     * @return created set
     */
    public static <E> SimpleSet<E> ofUniqueValues(int size, Iterable<E> iterable) {
        Iterator<E> iterator = iterable.iterator();
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = iterator.next();
        }
        return new SimpleSet<E>((E[])array);
    }

    @SafeVarargs
    public static <E> SimpleSet<E> of(E... values) {
        E[] array = removeDuplicates(values);

        return new SimpleSet<E>((E[]) array);
    }

    private static <E> E[] removeDuplicates(E[] values) {
        E[] array = values.clone();
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
        if (size == array.length) {
            return array;
        }
        return (E[]) Arrays.copyOf(array, size, values.getClass());
    }

    private final E[] array;

    public SimpleSet() {
        this((E[])new Object[0]);
    }

    @SafeVarargs
    private SimpleSet(E... uniqeValues) {
        array = uniqeValues;
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
