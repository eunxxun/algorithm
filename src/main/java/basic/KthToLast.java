package basic;

public class KthToLast {
    static class Reference {
        public int count = 0;
    }

    private static Node recursiveKthToLast(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }
        Node found = recursiveKthToLast(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }
        return found;
    }

    private static Node twoPointerKthToLast(Node first, int k) {
        Node p1 = first;
        Node p2 = first;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        int k = 1;
        Reference r = new Reference();
        Node found = recursiveKthToLast(head, k, r);
        Node found2 = twoPointerKthToLast(head, k);
        System.out.println(found.data);
        System.out.println(found2.data);
    }
}
