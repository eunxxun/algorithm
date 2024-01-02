package basic;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

class Queue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
        }
    }
    private Node<T> head; // remove from the head
    private Node<T> tail; // add things here

    public boolean isEmpty() {
        return head == null;
    }

    public T peek() {
        return head.data;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    public T remove() {
        if(head == null) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        //2개의 노드에 인접한 노드를 저장하는 linkedList에 상대방이 있는지 확인하고 없으면 서로 추가해준다.
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) { //stack에 값이 없을때까지 반복
            Node r = stack.pop();
            //가져온 노드의 자식들을 스택에 추가한다.
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<>();
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) { //큐가 빌때까지 반복
            Node r = queue.remove(); //큐에서 데이터 하나 가져오고
            for (Node n : r.adjacent) { //큐에서 꺼낸 자식 노드들을 큐에 추가
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }

    //재귀호출을 할때는 LinkedList가 노드의 주소를 가지고 있기 때문에 재귀함수는 노드를 받는 형태
    void dfsR(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r); //출력
        for (Node n : r.adjacent) {
            if (!n.marked) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }
}
/*
  0
 /
1 -- 3    7
|  / | \ /
| /  |  5
2 -- 4   \
          6 - 8
DFS (0)
0 1 3 5 7 6 8 4 2
BFS (0)
0 1 2 3 4 5 6 7 8
DFS(0) - Recursive
0 1 2 4 3 5 6 8 7
DFS (3)
3 5 7 6 8 4 2 1 0
BFS (3)
3 1 2 4 5 0 6 7 8
DFS(3) - Recursive
3 1 0 2 4 5 6 8 7
*/
public class GraphDFSBFS {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);
        g.dfsR(3);
    }
}
