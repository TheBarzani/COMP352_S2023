package tut3.LinkedList;

public interface ListADT<T> {
    
    /** Remove all contents from the list, so it is once again empty. */
    public void clear();

    /**Return an element from the list at the end position. */
    public T get();

    /**Insert an element at the end position. */
    public boolean insert(T t);

    /**Remove the first occurrence of any element from a non-empty list. */
    public T remove(T t);

    /**Return the number of elements in the list. */
    public int size();

    /**Return true if the list is empty, otherwise return false.*/
    public boolean isEmpty();

    /**Return true if the list is full, otherwise return false. */
    public boolean isFull();

    /**Returns true if the list contains the element, otherwise return false. */
    public boolean contains(T t);
    
    /**Remove the element at a specified location from a non-empty list. */
    // public T removeAt(int p);

    /**Replace an element at any position by another element. */
    // public T replace(T t);
}