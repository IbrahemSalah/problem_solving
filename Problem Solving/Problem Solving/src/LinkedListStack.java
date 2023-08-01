import java.util.LinkedList;

public class LinkedListStack {
    Node top;
    int size;

    void setupStack(int length) {
        top = null;
        size = 0;
    }

    void push(int data) {
        Node node = new Node(data, top);
        top = node;
        size++;
    }


    int pop() {
        int data = top.data;
        Node nextNode = top.next;
        top = nextNode;
        size--;
        return data;
    }

    int peak() {
        return top.data;
    }

    boolean isFull() {
        return false;
    }

    boolean isEmpty() {
        return top == null;
    }


    void clearStack() {
        top = null;
        size = 0;
    }


    void traverse() {
        Node traverseNode = top;

        while (traverseNode != null) {
            System.out.println(traverseNode.data);
            traverseNode = traverseNode.next;
        }

    }

    int size() {
        return size;
    }

}