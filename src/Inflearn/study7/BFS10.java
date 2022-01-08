package Inflearn.study7;

import java.util.LinkedList;
import java.util.Queue;

//DFS09와 같은 문제
public class BFS10 {
    Node root;
    public int BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i =0; i < len; i++){
                Node current = q.poll();
                if(current.lt == null && current.rt == null) return l;
                if(current.lt != null) q.offer(current.lt);
                if(current.rt != null) q.offer(current.rt);
            }
            l++;
        }
        return 0;
    }
        public static void main(String[] args) {
        BFS10 tree = new BFS10();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
