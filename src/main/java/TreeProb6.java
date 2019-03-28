public class TreeProb6{
    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<Integer>(20);
        TreeNode<Integer> node2 = new TreeNode<Integer>(8);
        TreeNode<Integer> node3 = new TreeNode<Integer>(22);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(12);
        TreeNode<Integer> node6 = new TreeNode<Integer>(10);
        TreeNode<Integer> node7 = new TreeNode<Integer>(14);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

        TreeNode<Integer> res = findSuccessor(node2);
        System.out.println(res.data);
    }

    public static <T> TreeNode<T> findSuccessor(TreeNode<T> n){
        if(n == null)
            return null;

        if(n.right != null)
            return findMinLeft(n.right);

        TreeNode<T> temp = n;
        TreeNode<T> parent = n.parent;

        while( parent != null && temp == parent.right){
            temp = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static <T> TreeNode<T> findMinLeft(TreeNode<T> n){
        TreeNode<T> temp = n;
        if(temp.left != null)
            temp = temp.left;

        return temp;
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