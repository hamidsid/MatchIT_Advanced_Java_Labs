package testqueue;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import queue_singlelinkedlist.FifoQueue;
import org.junit.Test;

public class TestAppendFifoQueue {

    FifoQueue<Integer> q1;
    FifoQueue<Integer> q2;

    @Before
    public void setUp() throws Exception {
        q1 = new FifoQueue<Integer>();
        q2 = new FifoQueue<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        q1 = null;
        q2 = null;
    }

    @Test
    public void testTwoEmptyQueue() {
        q1.append(q2);
        assertTrue(q1.peek() == null);
        assertTrue(q1.size() == 0);
        assertTrue(q2.size() == 0);
    }

    @Test
    public void testAppendEmptyToNonEmpty() {
        for (int i = 1; i <= 5; i++) {
            q2.offer(i);
        }
        q1.append(q2);
        assertFalse("Appending empty and non-empty queues results in non-empty queue", q1.peek() == null);
        assertTrue("size isn't correct", q1.size() == 5);
        assertEquals("q2 is empty after append", q2.peek(), null);
    }

    @Test
    public void testNonEmptyAppendsEmpty() {
        for (int i = 1; i <= 5; i++) {
            q1.offer(i);
        }

        q1.append(q2);
        assertTrue("size isn't correct", q1.size() == 5);

        for (int i = 1; i <= 5; i++) {
            int k = q1.poll();
            assertEquals("poll returns incorrect element", i, k);
        }

        assertTrue("q2 isn't empty", q2.isEmpty());

    }


    @Test
    public void testTwoNonEmptyQueues() {
        for (int i = 1; i <= 5; i++) {
            q1.offer(i);
            q2.offer(i + 5);
        }
        q1.append(q2);
        assertTrue("size isn't correct", q1.size() == 10);

        for (int i = 1; i <= 10; i++) {
            int k = q1.poll();
            assertEquals("poll returns incorrect element", i, k);
        }
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testAppendSelf() {

        exception.expect(IllegalArgumentException.class);
        q1.append(q1);
    }

}
