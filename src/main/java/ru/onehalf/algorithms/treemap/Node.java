package ru.onehalf.algorithms.treemap;

import java.util.Comparator;

/**
 * Date: 06.11.2017
 *
 * @author OneHalf
 */
class Node<K, V> {

    private Node<K, V> min;
    private Node<K, V> max;
    private K key;
    private V value;

    private final Comparator<? super K> comparator;

    Node(K key, V value, Comparator<? super K> comparator) {
        this.key = key;
        this.value = value;
        this.comparator = comparator;
    }

    public V put(Node<K, V> node) {
        if (this.equals(node)) {
            V oldValue = value;
            value = node.value;
            return oldValue;
        }

        if (node.greaterThan(this)) {
            if (max == null) {
                max = node;
                return null;
            } else {
                return max.put(node);
            }
        } else {
            if (min == null) {
                min = node;
                return null;
            } else {
                return min.put(node);
            }
        }
    }

    private boolean greaterThan(Node<K, V> anotherNode) {
        return comparator.compare(this.key, anotherNode.key) > 0;
    }

    private boolean equals(Node<K, V> node2) {
        return comparator.compare(this.key, node2.key) == 0;
    }

    K maxKey() {
        return max == null ? key : max.maxKey();
    }

    K minKey() {
        return min == null ? key : min.minKey();
    }
}
