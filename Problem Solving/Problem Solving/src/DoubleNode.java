public class DoubleNode {
    int data;
    Node next;

    Node prev;

    DoubleNode(int data) {
        this.data = data;
    }

    void setNext(Node next) {
        this.next = next;
    }


    void setPrev(Node prev) {
        this.prev = prev;
    }
}
