package tut3.LinkedList;

/**
 * Source code example for "A Practical Introduction to Data Structures and Algorithm Analysis, 3rd
 * Edition (Java)" by Clifford A. Shaffer Copyright 2008-2011 by Clifford A. Shaffer
 */

public interface List<T> {
    
    /** Remove all contents from the list, so it is once again
    empty. Client is responsible for reclaiming storage
    used by the list elements. */
    public void clear();

    /** Append an element at the end of the list. The client
    must ensure that the list’s capacity is not exceeded.
    @param item The element to be appended. */
    public void append(T item);

    /** @return The number of elements in the list. */
    public int length();

    /** @return The position of the current element. */
    public int currPos();

    /** Set current position.
    @param pos The position to make current. */
    public void moveToPos(int pos);

    /** @return The current element. */
    public T getValue();

    /** Insert an element at the current location. The client
    must ensure that the list’s capacity is not exceeded.
    @param item The element to be inserted. */
    public void insert(T item);

        /** Remove and return the current element.
    @return The element that was removed. */
    public T remove();

    /** Set the current position to the start of the list */
    public void moveToStart();

    /** Set the current position to the end of the list */
    public void moveToEnd();
    
    /** Move the current position one step left. No change
    if already at beginning. */
    public void prev();

    /** Move the current position one step right. No change
    if already at end. */
    public void next();

}

