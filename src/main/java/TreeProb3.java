import java.util.*;
import java.util.Iterator;

public class TreeProb3{

    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<Integer>(13);
        TreeNode<Integer> node2 = new TreeNode<Integer>(7);
        TreeNode<Integer> node3 = new TreeNode<Integer>(19);
        TreeNode<Integer> node4 = new TreeNode<Integer>(3);
        TreeNode<Integer> node5 = new TreeNode<Integer>(9);
        TreeNode<Integer> node6 = new TreeNode<Integer>(17);
        TreeNode<Integer> node7 = new TreeNode<Integer>(23);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        List<LinkedList<TreeNode<Integer>>> res = creatingLinkedListLevel(root);
        System.out.println(res.size());
        printByLevelList(res);
    }


    public static <T> List<LinkedList<TreeNode<T>>> creatingLinkedListLevel(TreeNode<T> root){
        if(root == null)
            return null;

        List<LinkedList<TreeNode<T>>> res = new ArrayList<>();
        LinkedList<TreeNode<T>> cur = new LinkedList<>();

        cur.add(root);
        while(cur.size() > 0){
            res.add(cur);
            LinkedList<TreeNode<T>> parent = cur;
            cur = new LinkedList<>();

            for(TreeNode<T> n : parent){
                if(n.left != null)
                    cur.add(n.left);

                if(n.right != null)
                    cur.add(n.right);
            }
        }
        return res;

    }


    public static <T> void printByLevelList(List<LinkedList<TreeNode<T>>> res){
        int deepth = 0;
        for(LinkedList<TreeNode<T>> ll : res){
            Iterator<TreeNode<T>> itr = ll.listIterator();
            while(itr.hasNext()){
                TreeNode<T> td = (TreeNode<T>) itr.next();
                System.out.println(td.data + " deepth : " + deepth);
            }
            deepth ++;
        }
    }

}

/*
class TreeNode<T> {
    public int data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode(int data){
        this.data = data;
    }
}
*/