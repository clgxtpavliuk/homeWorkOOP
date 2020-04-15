package junitHometask2.test;

import junitHometask2.Item;
import junitHometask2.LinkedList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class LinkedListTest<V> {

    private V expected;
    private V value;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{"Dog", 0}, {1, 0}});
    }

    public LinkedListTest(V expected, V value) {
        this.expected = expected;
        this.value = value;
    }

    private LinkedList linkedList = new LinkedList();

    @Test
    public void add() {
        linkedList.add(expected);
        assertEquals(expected, linkedList.get((Integer) value));
    }

    @Test
    public void remove() {
        linkedList.add(expected);
        linkedList.remove((Integer) value);
        assertEquals(value, linkedList.size());
    }

    @Test  (expected = IllegalArgumentException.class)
    public void getNeg() {
        linkedList.get((Integer) value);
    }

    @Test
    public void get() {
        linkedList.add(expected);
        assertEquals(expected, linkedList.get((Integer) value));
    }

    @Test
    public void size() {
        linkedList.add(expected);
        assertEquals(1, linkedList.size());
    }

}