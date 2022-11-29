package cctlibrary.utils;

/**
 *
 * @author aldan
 */
public class MyOwnQueue implements ArrayQueue {

    private String[] data;
    private int capacity;
    private int queueSize;
    private int first;//pointer of the first element (index) --front
    private int last;//pointer of the last element (index) --back

    public MyOwnQueue(int capacity) {
        this.capacity = capacity;
        this.data = new String[capacity];
        this.queueSize = 0;
        //both pointers (first and last) should be outside the array, because 
        //this one is empty, and there is no first or last element yet
        this.last = -1;
        this.first = -1;
    }

    public String[] getData() {
        return data;
    }

    @Override
    public boolean Enqueue(String newElement) {
        last++;
        data[last] = newElement;
        queueSize++;
        return true;
    }
    
    @Override
    public String Dequeue() {
        String response = null;
        if (last == 0) {
            response = data[0];
            data[0] = null;
            last = -1;
            queueSize = 0;
        } else if (last > 0) {
            response = data[0];
            for (int i = 0; i < last; i++) {
                data[i] = data[i + 1];
            }
            data[last]= null;
            last--;
            queueSize--;
        }
        return response;
    }

    @Override
    public String First() {
        return data[0];
    }

    @Override
    public String Last() {
        return data[last];
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        return queueSize == 0;
    }

}
