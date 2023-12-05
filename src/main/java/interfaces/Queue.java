package interfaces;

import java.util.NoSuchElementException;

public interface Queue<T> {
    
    /**
     * @post puts an item onto the "end" of the queue
     */
    void enqueue(T item);

    /**
     * @post removes an item from the "front" of the queue
     * @return the item removed
     * @throws NoSuchElementException if the Queue is empty
     */
    T dequeue();

    /**
     * @return true if the queue has no items, false otherwise
     */
    boolean isEmpty();

    /**
     * @post all items are removed, this Stack is empty
     * 
     */
    void makeEmpty();

    
}
