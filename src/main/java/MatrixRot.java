import java.util.*;
import java.util.Arrays;

public class MatrixRot{
    public static void main(String[] args){
        int[][] inp = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        if(inp.length == 0 || inp[0].length != inp.length)
            System.out.println("Please enter a valid marix of n x n");
        else{
            int[][] out = rotateMatrix(inp);
            System.out.println(Arrays.deepToString(out).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        }
    }

    public static int[][] rotateMatrix(int[][] mat){
        int n = mat.length;
        int[][] res = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0, m=n-1; j<n; j++, m--){
                res[i][j] = mat[m][i];
            }
        }
        return res;
    }
}