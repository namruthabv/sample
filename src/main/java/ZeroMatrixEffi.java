/* Java program to make entire row and col as zero if [row][col] == 0 */
import java.util.Arrays;

public class ZeroMatrixEffi{
    public static void main(String[] args){
        int[][] mat = {{1,2,0,4},{5,0,7,8},{9,10,11,12},{13,14,15,16}};
        boolean rowzero = false;
        boolean colzero = false;

        // row[0] is null
        for(int i=0; i<mat[0].length; i++){
            if(mat[0][i] == 0)
                rowzero = true;
            break;
        }

        // col[0] is null
        for(int i=0; i<mat.length; i++){
            if(mat[i][0] == 0)
                colzero = true;
            break;
        }

        // rest of row and col apart from zeroth row and col is zero or not
        for(int i=1; i<mat.length;i++){
            for(int j=1;j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0; // setting first element of col as zero
                    mat[0][j] = 0; // setting frist element of row as zero
                }
            }
        }

        // From prev loop to make all the row as zero
        for(int i=0; i<mat[0].length; i++){
            if(mat[0][i] == 0){
                nullifyCol(mat,i);
            }
        }

        // From prev loop to make all the col as zero
        for(int i=0; i<mat.length; i++){
            if(mat[i][0] == 0){
                nullifyRow(mat,i);
            }
        }

        // if firstrow is zero
        if(rowzero){
            nullifyRow(mat,0);
        }

        // if firstcol is zero
        if(rowzero){
            nullifyCol(mat,0);
        }

        System.out.println(Arrays.deepToString(mat).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


    }

    // nullifyRow
    public static void nullifyRow(int[][] mat, int row){
        for(int i=0; i<mat[0].length; i++){
            mat[row][i] = 0;
        }
    }

    // nullifyCol
    public static void nullifyCol(int[][] mat, int col){
        for(int i=0; i<mat.length; i++){
            mat[i][col] = 0;
        }
    }
}