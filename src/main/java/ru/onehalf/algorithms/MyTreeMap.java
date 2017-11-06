package ru.onehalf.algorithms;

import java.util.*;

public class MyTreeMap<K, V> implements NavigableMap<K, V> {

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
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public K lastKey() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public V get(Object key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Collections.singleton(Map.entry((K) "key", (V) "value"));
    }
}