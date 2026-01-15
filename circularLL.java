class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class circularLL{

    static Node insertAtBeginning(Node last, int key) {
        Node newNode = new Node(key);

        if (last == null) {
            newNode.next = newNode;
            return newNode;
        }

        newNode.next = last.next;
        last.next = newNode;

        return last;
    }

    static void printList(Node last) {
        if (last == null) return;

        Node head = last.next;
        Node temp = head;

        do {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != head) System.out.print(" -> ");
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) {
 
        Node first = new Node(2);
        first.next = new Node(3);
        first.next.next = new Node(4);

        Node last = first.next.next;
        last.next = first;


        last = insertAtBeginning(last, 5);

        printList(last);
    }
}