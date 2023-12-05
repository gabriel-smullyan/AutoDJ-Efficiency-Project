import java.util.NoSuchElementException;

import interfaces.Queue;

public class LinkedQueue<T> implements Queue<T>{

    private LinkedNode<T> front;
    private LinkedNode<T> end;

    public LinkedQueue(){
        front = null;
        end = null;
    }

    @Override
    public void enqueue(T item) {
        LinkedNode<T> newNode = new LinkedNode<T>(item);
        if (front == null){
            front = newNode;
            end = newNode;
        } else {
            end.setNext(newNode);
            end = newNode;
        }
    }

    @Override
    public T dequeue() {
        if (front == null){
            throw new NoSuchElementException("Queue is empty");
        }
        
        T temp = front.getItem();
        front = front.getNext();
        
        if (front == null){
            end = null;
        }

        return temp;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void makeEmpty() {
        front = null;
        end = null;
    }
    
}
