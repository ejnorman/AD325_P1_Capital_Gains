package Deque;

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("Queue is empty");
    }
}
