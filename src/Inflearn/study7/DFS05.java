package Inflearn.study7;

//이진트리순회
public class DFS05 {
    Node root;
    public void DFS(Node root){
        if(root == null) return;
        else{
            System.out.println(root.data+" ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }
    public static void main(String[] args) {
        DFS05 tree=new DFS05();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);
    }
}

class Node{
    int data;
    Node lt, rt; //Node클래스의 객체 주소를 저장
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}