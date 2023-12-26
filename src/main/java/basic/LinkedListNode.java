package basic;

class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;

        Node() {}
        Node(int d) {
            this.data = d;
        }
    }

    LinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups() {
        Node n = header;
        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) { //r은 마지막 노드까지 가지 않음. -> r.next.data
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}
public class LinkedListNode {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(2);
        linkedList.append(1);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(2);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.retrieve();
        linkedList.removeDups();
        linkedList.retrieve();
    }
}
