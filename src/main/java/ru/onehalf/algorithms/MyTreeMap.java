package ru.onehalf.algorithms;

import java.util.*;

public class MyTreeMap<K, V> implements NavigableMap<K, V> {

    private int size  = 0;

    @Override
    public Entry<K, V> lowerEntry(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public K lowerKey(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Entry<K, V> floorEntry(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public K floorKey(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public K ceilingKey(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public K higherKey(K key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Entry<K, V> firstEntry() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Entry<K, V> lastEntry() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public NavigableMap<K, V> descendingMap() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public NavigableSet<K> navigableKeySet() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public NavigableSet<K> descendingKeySet() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Comparator<? super K> comparator() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public K firstKey() {
        if (isEmpty()) {
            return null;
        }
        return (K) "key1";
    }

    @Override
    public K lastKey() {
        if (isEmpty()) {
            return null;
        }
        return (K) ("key" + size());
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
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return !isEmpty() && "value".equals(value);
    }

    @Override
    public V get(Object key) {
        if (!((String) key).startsWith("key")) {
            return null;
        }
        String substring = ((String) key).substring(3);
        try {
            return (Integer.parseInt(substring) <= size) ? (V) "value" : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public V put(K key, V value) {
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        size--;
        return (V) "value";
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        };
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = "key" + (i + 1);
        }
        return (Set<K>) SimpleSet.of(strings);
    }

    @Override
    public Collection<V> values() {
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = "value";
        }
        return (Set<V>) SimpleSet.of(strings);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Map.Entry<K, V>[] entries = new Map.Entry[size];
        for (int i = 0; i < size; i++) {
            entries[i] = Map.entry((K) ("key" + (i + 1)), (V) "value");
        }
        return SimpleSet.of(entries);

    }
}