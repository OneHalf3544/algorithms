package ru.onehalf.algorithms;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;
import static org.hamcrest.collection.IsMapWithSize.anEmptyMap;
import static org.hamcrest.core.Is.is;
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
        assertThat(map, is(anEmptyMap()));
    }

    @Test
    void should_returnExpectedValue_when_existedKeyWasUsed() {
        MyTreeMap<String, String> map = new MyTreeMap<>();
        map.put("key", "value");

        assertAll("map contains entry(key, value)",
                () -> assertThat(map, hasEntry("key", "value")),
                () -> assertThat(map, hasKey("key")),
                () -> assertThat(map, hasValue("value")),
                () -> assertThat(map, aMapWithSize(1)),
                () -> assertEquals(Collections.singleton("key"), map.keySet(), "keySet"),
                () -> assertEquals(Collections.singleton("value"), map.values(), "values"),
                () -> assertEquals("value", map.get("key"), "get(key)"),
                () -> assertTrue(map.containsKey("key"), "contains(key)")
        );
    }

    @Test
    void should_() {

    }
}