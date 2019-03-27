public class TreeProb2{

    public static void main(String[] args){
        Integer[] arrayInput = {1, 3, 5, 7, 9, 13, 17};
        createBinTree(arrayInput);
    }

    public static TreeNode<Integer> createBinTree(Integer sortedArr[]){
        return creatingTree(sortedArr, 0, sortedArr.length-1);
    }

    public static TreeNode<Integer> creatingTree(Integer sortedArr[], int start , int end){
        if (start > end || start < 0 || end > sortedArr.length || sortedArr.length == 0)
            return null;
        int mid = start + ((end+1 - start)/2);
        TreeNode<Integer> root = new TreeNode(sortedArr[mid]);
        root.left = creatingTree(sortedArr,start,mid-1);
        root.right = creatingTree(sortedArr,mid+1,end);
        return root;
    }
}

class TreeNode<Integer> {
    public int data;
    public TreeNode<Integer> left;
    public TreeNode<Integer> right;
    public TreeNode<Integer> parent;

    public TreeNode(int data){
        this.data = data;
    }
}