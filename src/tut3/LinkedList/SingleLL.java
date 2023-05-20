package tut3.LinkedList;

public class SingleLL<T> implements ListADT<T> {

    private Node<T> head;
    private Node<T> tail;
    private int sz = 0;

    /*Shell class that contains a pointer and the data. */
    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    // Default Constructor
    public SingleLL(){
        head = null;
        tail = null;
        sz = 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        sz = 0;
    }

    @Override
    public T get(){
        if (head == null) return null;
        return tail.item;

    };

    @Override
    public boolean insert(T t) {
         /* Checking for duplicates. */
        if (contains(t)) return false;

        /* Case: no elements */
        if (head == null){
            head = new Node<>();
            head.item = t; 
            head.next = null;
            tail = head;
            sz++;
            return true;            
        }

        /* Case: more than one element element. */
        tail.next = new Node<>();
        tail = tail.next;
        tail.item = t;
        tail.next = null;
        sz++;
        return true;
    }

    @Override
    public T remove(T t) {
        /* Case: not found or empty list. */
        if (!contains(t)) return null;

        Node<T> ptr = head;

        /* Check until item is found. */
        if (!ptr.item.equals(t)) {
            while (!ptr.next.item.equals(t)) {
                ptr = ptr.next;
                
            }
        }

        /* Case: element at head */
        if (ptr ==head && ptr.item.equals(t)) {
            T elem = ptr.item;

            head = head.next;

            /* Sub-Case: only one elem in LL */
            if (tail == ptr) {
                tail = null;
            }

            sz--;
            return elem;
        }

        T elem = ptr.next.item;

        ptr.next = ptr.next.next;

        sz--;
        return elem;
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(T t) {
        /* Case: Empty LL */
        if (head == null) return false;

        Node<T> ptr = head;
    
        /* Check until item is found or to the end if not. */
        while (ptr != null && !ptr.item.equals(t)) {
            ptr = ptr.next;
        }
    
        /* Return null if not found. */
        if (ptr == null) return false;
          
        return true;
    }

    public T find(T t){
        /* Case: Empty LL */
        if (head == null) return null;

        Node<T> ptr = head;
    
        /* Check until item is found or to the end if not. */
        while (ptr != null && !ptr.item.equals(t)) {
            ptr = ptr.next;
        }
    
        /* Return null if not found. */
        if (ptr == null) return null;
            
        return ptr.item;
    }
    
}
