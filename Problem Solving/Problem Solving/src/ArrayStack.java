
public class ArrayStack {
    int top;
    private int[] elements;

    void setupStack(int length) {
        elements = new int[length];
        top = 0;
    }


    int size(){
        return top;
    }

    void push(int element) {
        elements[top] = element;
        top++;
    }

    int pop() {
        top--;
        return elements[top];
    }

    int peak() {
        return elements[top - 1];
    }

    void clearStack(){
        top = 0;
    }

    void traverse(){
        for(int i = top; i > 0; i--)
            System.out.println(elements[i-1]);
    }

    boolean isFull() {
        return elements.length == top;
    }

    boolean isEmpty() {
        return top == 0;
    }
}