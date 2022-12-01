package cctlibrary.utils;

//to define the methods implemented in the classes that uses this interface
public interface ArrayQueue {

    /**
     * Adds an element at the back of the queue
     *
     * @param newElement
     * @return false is capacity full
     */
    public boolean Enqueue(String newElement);

    /**
     * Removes an element from the front of the queue
     *
     * @return null if queue is empty
     */
    public String Dequeue();

    /**
     * First element of the queue without removing it
     *
     * @return null if empty
     */
    public String First();

    /**
     * Last element of the queue without removing it
     *
     * @return null if empty
     */
    public String Last();

    /**
     * Number of elements in the queue
     *
     * @return
     */
    public int size();

    /**
     * True if there is no elements in the queue
     *
     * @return
     */
    public boolean isEmpty();

}
