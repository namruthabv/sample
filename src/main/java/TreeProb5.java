public class TreeProb5{
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

        boolean res = isBST(root);
        System.out.println(res);
    }

    public static boolean isBST(TreeNode<Integer> root){
        if(root == null)
            return true;

        if(root.left != null && root.right != null){
            //System.out.println("root.left : " + root.left.data + " root.right : " + root.right.data);
            if(root.left.data > root.data || root.right.data < root.data){
                return false;
            }
            isBST(root.left);
            isBST(root.right);
        }
        return true;
    }
}

/*
class TreeNode<Integer>{
    int data;
    TreeNode<Integer> left = null;
    TreeNode<Integer> right = null;
    TreeNode<Integer> parent = null;
    public TreeNode(int data){
        this.data = data;
    }
}
*/