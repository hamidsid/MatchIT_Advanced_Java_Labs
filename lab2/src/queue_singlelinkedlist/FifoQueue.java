package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private QueueNode<E> last;
    private int size;

    public FifoQueue() {
        super();
        last = null;
        size = 0;
    }

    /**
     * Inserts the specified element into this queue, if possible
     * post:	The specified element is added to the rear of this queue
     *
     * @param e the element to insert
     * @return true if it was possible to add the element
     * to this queue, else false
     */
    public boolean offer(E e) {
        if (size == 0) {
            last = new QueueNode<E>(e);
            last.next = last;
        } else {
            QueueNode<E> temp = last.next; // let last node to point to the first node
            last.next = new QueueNode<E>(e); // put the new item to the last node
            last = last.next;
            last.next = temp;
        }
        size++;  //increment the size once the item is added successfully.
        return true;
    }

    /**
     * Returns the number of elements in this queue
     *
     * @return the number of elements in this queue
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * returning null if this queue is empty
     *
     * @return the head element of this queue, or null
     * if this queue is empty
     */
    public E peek() {
        if (size > 0) {
            return last.next.element;
        }
        return null;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or null if this queue is empty.
     * post:	the head of the queue is removed if it was not empty
     *
     * @return the head of this queue, or null if the queue is empty
     */
    public E poll() {

        if (size == 0) {
            return null;
        } else {
            QueueNode<E> temp = last.next;
            last.next = temp.next;
            size--;
            return temp.element;
        }
    }


    /**
     * Appends the specified queue to this queue
     * post: all elements from the specified queue are appended
     * to this queue. The specified queue (q) is empty after the call.
     *
     * @param q the queue to append
     * @throws IllegalArgumentException if this queue and q are identical
     */

    public void append(FifoQueue<E> q) {

        if (this.equals(q)) {
            throw new IllegalArgumentException();
        }

        //if this queue is empty and q queue is not
        if (this.isEmpty() && !q.isEmpty()) {
            this.last = q.last;
            this.size = q.size;
        }

        //if both queues are not empty
        else if (!this.isEmpty() && !q.isEmpty()) {
            QueueNode<E> temp = this.last.next;
            this.last.next = q.last.next;
            this.last = q.last;
            q.last.next = temp;
            this.size += q.size;
        }

        q.last = null;
        q.size = 0;

    }


    /**
     * Returns an iterator over the elements in this queue
     *
     * @return an iterator over the elements in this queue
     */
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {

        private QueueNode<E> pos;

        private QueueIterator() {
            if (last != null) {
                pos = last.next;    //if queue is not null then start from the head of queue;
            } else {
                pos = null;
            }
        }

        @Override
        public boolean hasNext() {
            return pos != null;
        }

        @Override
        public E next() {

            //if there is no other element then throw exception
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E e = pos.element;
            if (pos != last) {
                pos = pos.next;
            } else {
                pos = null;
            }
            return e;
        }
    }

    private static class QueueNode<E> {
        E element;
        QueueNode<E> next;

        private QueueNode(E x) {
            element = x;
            next = null;
        }
    }

}
