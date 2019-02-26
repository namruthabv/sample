import java.util.*;
import java.util.Arrays;

public class ArrayStr1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string :");
        String st1 = in.next();
        char[] arr = st1.toCharArray();

        Arrays.sort(arr);
        boolean isUniq = true;
        for (int i=0; i<arr.length - 1; i++ ){
            if (arr[i] == arr[i+1])
            {
                isUniq = false;
            }
        }
        if(isUniq){
            System.out.println("The given string " + st1 + " consists of unique character ");
        }
        else{
            System.out.println("The given string " + st1 + " does not consists of unique character ");
        }
    }
}