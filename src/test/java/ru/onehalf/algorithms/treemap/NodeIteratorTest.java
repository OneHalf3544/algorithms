package ru.onehalf.algorithms.treemap;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

import static java.util.Map.entry;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NodeIteratorTest {

    @Test
    void should_iterate() {
        Node<String, String> root = new Node<>("key2", "value", String::compareTo);
        root.setMin(new Node<>("key1", "value", String::compareTo));
        root.setMax(new Node<>("key3", "value", String::compareTo));

        assertThat(root, IsIterableContainingInOrder.contains(
                entry("key1", "value"),
                entry("key2", "value"),
                entry("key3", "value")
        ));
    }

}