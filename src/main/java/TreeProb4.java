public class TreeProb4{
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
        node4.left = node6;
        node5.left = node7;

        boolean res = isBalancedBT(root);
        System.out.println(res);

    }

    public static boolean isBalancedBT(TreeNode<Integer> root){
        if(root == null)
            return false;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(left > right)
            return false;
        return true;
    }

    public static int findHeight(TreeNode<Integer> root){
        if(root == null)
            return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return left > right ? left+1 : right+1;
    }

}

/*
class TreeNode<Integer>{
    int data;
    TreeNode<Integer> left;
    TreeNode<Integer> right;
    TreeNode<Integer> parent;
    public TreeNode(int data){
        this.data = data;
    }
}

*/