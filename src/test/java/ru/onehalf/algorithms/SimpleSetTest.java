package ru.onehalf.algorithms;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Date: 06.11.2017
 *
 * @author OneHalf
 */
class SimpleSetTest {

    @Test
    void should_createEmptySet_when_noArgsConstructorCalled() {
        Set<String> set = new SimpleSet<>();
        assertAll("empty set",
                () -> assertEquals(0, set.size(), "size"),
                () -> assertTrue(set.isEmpty(), "isEmpty")
        );
    }

    @Test
    void should_createSetWithValues_when_createdUsingUniqueValues() {
        Set<String> set = SimpleSet.of("one", "two");
        assertAll("set with two values",
                () -> assertEquals(2, set.size(), "size"),
                () -> assertThat(set, IsIterableContainingInOrder.contains("one", "two")),
                () -> assertFalse(set.isEmpty(), "isEmpty")
        );
    }

    @Test
    void should_createSetWithValues_when_createdUsingNonUniqueValues() {
        Set<String> set = SimpleSet.of("one", "two", "two", "three");
        assertAll("set with three values",
                () -> assertEquals(3, set.size(), "size"),
                () -> assertThat(set, IsIterableContainingInOrder.contains("one", "two", "three")),
                () -> assertFalse(set.isEmpty(), "isEmpty")
        );
    }

    @Test
    void should_returnTrue_when_containsMethodCalledForExistedElement() {
        Set<String> set = SimpleSet.of("one", "two", "three");
        assertThat(set, hasItem("two"));
    }

    @Test
    void should_returnFalse_when_containsMethodCalledForUnexistedElement() {
        Set<String> set = SimpleSet.of("one", "two", "three");
        assertThat(set, not(hasItem("notANumber")));
    }

    @Test
    void should_returnTrue_when_containsAllMethodCalledForExistedElements() {
        Set<String> set = SimpleSet.of("one", "two", "three");
        assertTrue(set.containsAll(SimpleSet.of("one", "two")));
    }

    @Test
    void should_returnTrue_when_containsAllMethodCalledForUnexistedElements() {
        Set<String> set = SimpleSet.of("one", "two", "three");
        assertFalse(set.containsAll(SimpleSet.of("one", "another")));
        assertFalse(set.containsAll(SimpleSet.of("other", "another")));
    }
}