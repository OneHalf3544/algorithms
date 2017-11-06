package ru.onehalf.algorithms;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;
import static org.hamcrest.collection.IsMapWithSize.anEmptyMap;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Date: 06.11.2017
 *
 * @author OneHalf
 */
class MyTreeMapTest {

    @Test
    void should_beEmpty_when_created() {
        MyTreeMap<String, String> map = new MyTreeMap<>();
        assertAll("collection is empty",
                () -> assertEquals(0, map.size(), "size"),
                () -> assertTrue(map.isEmpty(), "isEmpty")
        );
    }

    @Test
    void should_addKeyValue_when_mapIsEmpty() {
        MyTreeMap<String, String> map = new MyTreeMap<>();
        map.put("key1", "value");

        assertAll("map contains entry(key, value)",
                () -> assertThat(map, hasEntry("key1", "value")),
                () -> assertThat(map, hasKey("key1")),
                () -> assertThat(map, hasValue("value")),
                () -> assertThat(map, aMapWithSize(1)),
                () -> assertEquals(Collections.singleton("key1"), map.keySet(), "keySet"),
                () -> assertEquals(Collections.singleton("value"), map.values(), "values"),
                () -> assertEquals("value", map.get("key1"), "get(key1)"),
                () -> assertTrue(map.containsKey("key1"), "contains(key1)")
        );
    }

    @Test
    void should_notContainsKey_when_itsNotPresentInMap() {
        MyTreeMap<String, String> map = new MyTreeMap<>();
        map.put("key1", "value");

        assertAll("not contains 'unexistedKey'",
                () -> assertThat(map, not(hasEntry(is("unexistedKey"), anything()))),
                () -> assertThat(map, not(hasKey("unexistedKey"))),
                () -> assertThat(map.keySet(), not(hasItem("unexistedKey"))),
                () -> assertNull(map.get("unexistedKey"), "get(unexistedKey)"),
                () -> assertFalse(map.containsKey("unexistedKey"), "contains(unexistedKey)")
        );
    }

    @Test
    void should_iterateInKeysCompareOrder() {
        Map<String, String> map = new MyTreeMap<>();
        map.put("key1", "value");
        map.put("key2", "value");
        map.put("key3", "value");

        assertAll("iterate entries in order of comparing",
                () -> assertThat(map.entrySet(), IsIterableContainingInOrder.contains(
                        Map.entry("key1", "value"),
                        Map.entry("key2", "value"),
                        Map.entry("key3", "value")
                )),
                () ->  assertThat(map.keySet(), IsIterableContainingInOrder.contains("key1", "key2", "key3"))
        );
    }
}