package Inflearn.study7;

import java.util.LinkedList;
import java.util.Queue;

//이진트리순회(넓이우선탐색)
public class BFS07 {
    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int level = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print(level+" : ");
            for(int i = 0; i < len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt != null) Q.add(cur.lt);
                if(cur.rt != null) Q.add(cur.rt);
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BFS07 tree = new BFS07();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
