package ru.onehalf.algorithms.treemap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Date: 06.11.2017
 *
 * @author OneHalf
 */
class Node<K, V> implements Iterable<Map.Entry<K, V>> {

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

    V put(Node<K, V> node) {
        if (this.equals(node)) {
            V oldValue = value;
            value = node.value;
            return oldValue;
        }

        if (node.greaterThan(this)) {
            if (getMax() == null) {
                setMax(node);
                return null;
            } else {
                return getMax().put(node);
            }
        } else {
            if (getMin() == null) {
                setMin(node);
                return null;
            } else {
                return getMin().put(node);
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
        return getMax() == null ? key : getMax().maxKey();
    }

    K minKey() {
        return getMin() == null ? key : getMin().minKey();
    }

    Map.Entry<K, V> toEntry() {
        return Map.entry(key, value);
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new NodeIterator<>(this);
    }

    Node<K, V> getMin() {
        return min;
    }

    void setMin(Node<K, V> min) {
        this.min = min;
    }

    Node<K, V> getMax() {
        return max;
    }

    void setMax(Node<K, V> max) {
        this.max = max;
    }

    private static class NodeIterator<K, V> implements Iterator<Map.Entry<K, V>> {

        enum CurrentPart {
            MIN, THIS, MAX
        }

        private final Node<K, V> node;
        private CurrentPart currentStage;
        private Iterator<Map.Entry<K, V>> subIterator;

        NodeIterator(Node<K, V> node) {
            this.node = node;
            currentStage = CurrentPart.MIN;
            subIterator = node.getMin() == null ? null : node.getMin().iterator();
        }

        @Override
        public boolean hasNext() {
            return currentStage == CurrentPart.MIN
                    || (subIterator != null && subIterator.hasNext());
        }

        @Override
        public Map.Entry<K, V> next() {
            if (subIterator != null && subIterator.hasNext()) {
                return subIterator.next();
            } else {
                if (currentStage == CurrentPart.MIN) {
                    currentStage = CurrentPart.THIS;
                    subIterator = node.max == null ? null : node.max.iterator();
                    return node.toEntry();

                }
            }
            throw new NoSuchElementException();
        }
    }
}
