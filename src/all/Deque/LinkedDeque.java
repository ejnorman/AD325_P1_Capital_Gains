package Deque;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode<T> head;
    private DLNode<T> tail;

    public LinkedDeque() {
        head = null;
        tail = null;
    }

    /**
     * {@inheritDoc}
     */
    public void addToFront(T newEntry){
        DLNode<T> newNode = new DLNode<>(newEntry);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head; //comes before current head
            head.prev = newNode;
            head = newNode; //is the new head
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addToBack(T newEntry){
        DLNode<T> newNode = new DLNode<>(newEntry);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode; //comes after current tail
            newNode.prev = tail;
            tail = newNode; //is the new tail
        }
    }

    /**
     * {@inheritDoc}
     */
    public T removeFront()  {
        if(head == null){
            throw new EmptyQueueException();
        }

        DLNode<T> temp = head;

        if(head == tail){
            head = null;
            tail = null;
        }else {
            head = head.next; //move head one over
            head.prev = null; //no reference to previous head
            temp.next = null; //previous head has no reference to new head
        }
        return temp.data;
    }

    /**
     * {@inheritDoc}
     */
    public T removeBack() {
        if(tail == null){
            throw new EmptyQueueException();
        }

        DLNode<T> temp = tail;

        if(head == tail){
            head = null;
            tail = null;
        }else {
            tail = tail.prev; //move tail one back
            tail.next = null; //new tail has no reference to previous tail
            temp.prev = null; //previous tail has no reference to new tail
        }
        return temp.data;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty(){
        return head == null && tail == null;
    }

    /**
     * {@inheritDoc}
     */
    public T getFront() {
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return head.data;
    }

    /**
     * {@inheritDoc}
     */
    public T getBack() {
        if(isEmpty()){
            throw new EmptyQueueException();
        }
        return tail.data;
    }

    /**
     * {@inheritDoc}
     */
    public void clear(){
        this.head = null;
        this.tail = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new IteratorForLinkedList<T>(head);
    }

    /**
     * {@inheritDoc}
     */
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

        /**
         * Get value of node
         * @return data in node
         */
        public T getData(){
            return this.data;
        }

        /**
         * Set value of node
         * @param data to give to node
         */
        public void setData(T data){
            this.data = data;
        }

        /**
         * Give the next node
         * @return next node
         */
        public DLNode<T> getNextNode(){
            return this.next;
        }

        /**
         * Set path to next node
         * @param nextNode the next node
         */
        public void setNextNode(DLNode<T> nextNode){
            this.next = nextNode;
        }

        /**
         * Give the previous node
         * @return previous node
         */
        public DLNode<T> getPrevNode(){
            return this.prev;
        }

        /**
         * Set path to previous node
         * @param prevNode previous node
         */
        public void setPrevNode(DLNode<T> prevNode){
            this.prev = prevNode;
        }
    }

    public static class IteratorForLinkedList<T> implements Iterator<T>{

        private DLNode<T> current;

        public IteratorForLinkedList(DLNode<T> node){
            current = node;
        }

        /**
         * Returns value of current element and moves to next element
         * @return value of current element
         */
        @Override
        public T next(){
            if(!hasNext()){
                throw new EmptyStackException();
            }
            T data = current.data; //to be returned
            current = current.next; //move through list
            return data;
        }

        /**
         * Checks if there is another element in the list
         * @return true if there is a next element, false if there isn't
         */
        @Override
        public boolean hasNext(){
            return current != null;
        }
    }
}
