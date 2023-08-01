public class LinkedListListImpl {
    int size;

    Node head;

    LinkedListListImpl() {
        size = 0;
    }

    int size() {
        return size;
    }

    void insert(int value) {
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }

        Node lastNode = head;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = new Node(value);
        size++;
    }


    void insert(int value, int position) {
        Node newNode = new Node(value);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node insertPositionNode = head;

        for (int i = 0; i < position - 1; i++) {
            insertPositionNode = insertPositionNode.next;
        }

        newNode.next = insertPositionNode.next;
        insertPositionNode.next = newNode;
        size++;
    }

    void delete(int position) {
        if (position == 0) {
            head = head.next;
            size--;
            return;
        }

//        Node deletePositionNode = head;
//        Node prevNodeOfDeletedNode = null;
//
//        for (int i = 0; i < position; i++) {
//            if (i == position - 1) {
//                prevNodeOfDeletedNode = deletePositionNode;
//            }
//            deletePositionNode = deletePositionNode.next;
//        }
//
//        prevNodeOfDeletedNode.next = deletePositionNode.next;
//        size--;

        Node prevNodeOfDeletedNode = head;

        for (int i = 0; i < position - 1; i++) {
            prevNodeOfDeletedNode = prevNodeOfDeletedNode.next;
        }

        prevNodeOfDeletedNode.next = prevNodeOfDeletedNode.next.next;
        size--;
    }


    void traverse() {
        Node traversingNode = head;


        while (traversingNode != null) {
            System.out.print(traversingNode.data + ", ");
            traversingNode = traversingNode.next;
        }
        System.out.println();
    }
}
