package Deque;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedDeque<T> implements Iterable<T> {
    private DLNode<T> head;
    private DLNode<T> tail;

    public void addToFront(T newEntry){
        DLNode<T> newNode = new DLNode<>(newEntry);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addToBack(T newEntry){
        DLNode<T> newNode = new DLNode<>(newEntry);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public T removeFront() throws EmptyQueueException {
        if(head == null){
            throw new EmptyQueueException();
        }

        DLNode<T> temp = head;

        if(head == tail){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        return temp.data;
    }

    public T removeBack() throws EmptyQueueException {
        if(tail == null){
            throw new EmptyQueueException();
        }

        DLNode<T> temp = tail;

        if(head == tail){
            head = null;
            tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        return temp.data;
    }

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public T getFront() {
        return head.data;
    }

    public T getBack() {
        return tail.data;
    }

    public void clear(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorForLinkedList<T>(head);
    }

    public Iterator<T> getIterator(){
        return iterator();
    }

    public static class DLNode<T>{

        private DLNode<T> next;
        private DLNode<T> prev;
        private T data;

        public DLNode(){
            this.next = null;
            this.prev = null;
            this.data = null;
        }

        public DLNode(T data) {
            this.next = null;
            this.prev = null;
            this.data = data;
        }

        public T getData(){
            return this.data;
        }

        public void setData(T data){
            this.data = data;
        }

        public DLNode<T> getNextNode(){
            return this.next;
        }

        public void setNextNode(DLNode<T> nextNode){
            this.next = nextNode;
        }

        public DLNode<T> getPrevNode(){
            return this.prev;
        }

        public void setPrevNode(DLNode<T> prevNode){
            this.prev = prevNode;
        }
    }

    public static class IteratorForLinkedList<T> implements Iterator<T>{

        private DLNode<T> current;

        public IteratorForLinkedList(DLNode<T> node){
            current = node;
        }

        @Override
        public T next(){
            if(!hasNext()){
                throw new EmptyStackException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public boolean hasNext(){
            return current != null;
        }
    }
}
