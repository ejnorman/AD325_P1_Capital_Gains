import Deque.LinkedDeque;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedDequeTest {

    @Test
    void addToFront() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        assertEquals(24, d.getFront());
    }

    @Test
    void addToBack() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(35);
        assertEquals(35, d.getBack());
    }

    @Test
    void removeFront() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        d.addToFront(35);
        assertEquals(35, d.removeFront());
    }

    @Test
    void removeBack() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(24);
        d.addToBack(35);
        assertEquals(35, d.removeBack());
    }

    @Test
    void isEmpty() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        d.removeFront();
        assertTrue(d.isEmpty());
    }

    @Test
    void getFront() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        assertEquals(24, d.getFront());
    }

    @Test
    void getBack() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToBack(35);
        assertEquals(35, d.getBack());
    }

    @Test
    void clear() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        d.addToFront(35);
        d.clear();
        assertTrue(d.isEmpty());
    }

    @Test
    void iterator() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        Iterator<Integer> it = d.iterator();
        assertEquals(24, it.next());
    }

    @Test
    void getIterator() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        Iterator<Integer> it = d.getIterator();
        assertEquals(24, it.next());
    }

    @Test
    void getData() {
        LinkedDeque.DLNode<Integer> n = new LinkedDeque.DLNode<>(24);
        assertEquals(24, n.getData());
    }

    @Test
    void setData() {
        LinkedDeque.DLNode<Integer> n = new LinkedDeque.DLNode<>();
        n.setData(24);
        assertEquals(24, n.getData());
    }

    @Test
    void getNextNode() {
        LinkedDeque.DLNode<Integer> n1 = new LinkedDeque.DLNode<>();
        LinkedDeque.DLNode<Integer> n2 = new LinkedDeque.DLNode<>();
        n1.setNextNode(n2);
        assertEquals(n2, n1.getNextNode());
    }

    @Test
    void setNextNode() {
        LinkedDeque.DLNode<Integer> n1 = new LinkedDeque.DLNode<>();
        LinkedDeque.DLNode<Integer> n2 = new LinkedDeque.DLNode<>();
        n1.setNextNode(n2);
        assertEquals(n2, n1.getNextNode());
    }

    @Test
    void getPrevNode() {
        LinkedDeque.DLNode<Integer> n1 = new LinkedDeque.DLNode<>();
        LinkedDeque.DLNode<Integer> n2 = new LinkedDeque.DLNode<>();
        n1.setPrevNode(n2);
        assertEquals(n2, n1.getPrevNode());
    }

    @Test
    void setPrevNode() {
        LinkedDeque.DLNode<Integer> n1 = new LinkedDeque.DLNode<>();
        LinkedDeque.DLNode<Integer> n2 = new LinkedDeque.DLNode<>();
        n1.setPrevNode(n2);
        assertEquals(n2, n1.getPrevNode());
    }

    @Test
    void next() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        d.addToFront(35);
        Iterator<Integer> it = d.iterator();
        assertEquals(35, it.next());
    }

    @Test
    void hasNext() {
        LinkedDeque<Integer> d = new LinkedDeque<>();
        d.addToFront(24);
        Iterator<Integer> it = d.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }
}
