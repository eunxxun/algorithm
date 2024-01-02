package others;


class LinkedList {
    Node header;

    public static class Node {
        int data;
        Node next = null;

        Node() {}
        Node(int d) {
            this.data = d;
        }

        Node get(int index) {
            Node current = this;
            for (int i = 0; i < index; i++) {
                if (current.next == null) {
                    return null;
                }
                current = current.next;
            }
            return current;
        }
    }

    LinkedList() {
        header = new Node();
    }

    Node get(int i) {
        Node current = header.next;
        int index = 0;

        while (current != null) {
            if (index == i) {
                return current;
            }
            index++;
            current = current.next;
        }

        return null;
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
    /* LinkedList에 있는 노드들을 x값을 기준으로 값이 작은것들은 왼쪽, 큰것들은 오른쪽 두파트로 나누시오. (단, x는 오른쪽 파트 어디에 놔도 상관 없음)
     * */
//    private static Node partition(Node n, int x) {
//        Node s1 = null;
//        Node e1 = null;
//        Node s2 = null;
//        Node e2 = null;
//
//        while (n != null) {
//            Node next = n.next;
//            n.next = null;
//            if (n.data < x) {
//                if (s1 == null) {
//                    s1 = n;
//                    e1 = s1;
//                } else {
//                    e1.next = n;
//                    e1 = n;
//                }
//            } else {
//                if (s2 == null) {
//                    s2 = n;
//                    e2 = s2;
//                } else {
//                    e2.next = n;
//                    e2 = n;
//                }
//            }
//            n = next;
//        }
//        if (s1 == null) {
//            return s2;
//        }
//        e1.next = s2;
//        return s1;
//    }
//
//    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//        linkedList.append(2);
//        linkedList.append(1);
//        linkedList.append(1);
//        linkedList.append(2);
//        linkedList.append(3);
//        linkedList.append(4);
//        linkedList.append(2);
//        linkedList.append(2);
//        linkedList.append(4);
//        linkedList.retrieve();
//        linkedList.removeDups();
//        linkedList.retrieve();
////        Node n = partition(linkedList.get(1), 5);
//    }
}
