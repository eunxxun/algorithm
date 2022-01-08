package Inflearn.study7;

public class DFS09 {
    Node root;
    public int DFS(int L, Node root){
        if(root.lt == null && root.rt == null){//말단노드
            return L;
        }else{
            return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
        }
    }
    public static void main(String args[]) {
        DFS09 tree=new DFS09();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
