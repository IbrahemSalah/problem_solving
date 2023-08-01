public class ArrayQueue {

    int front;
    int rear;
    int size;

    private int[] elements;

    public void setupQueue(int length) {
        front = 0;
        rear = -1;
        size = 0;
        elements = new int[length];
    }

    public void inqueue(int element) {
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }

    public int dequeue() {
        int element = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    void traverse() {
        int pos = front;

        for (int i = 0; i < size; i++) {
            System.out.println(elements[pos]);
            pos = (pos + 1) % elements.length;
        }
    }
}
