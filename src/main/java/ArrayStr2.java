/* Program to check if two strings are permutation of each other */
import java.util.*;

public class ArrayStr2{

    public static boolean areTwoStringsPerm(String inp_str1, String inp_str2){
        if(inp_str1.length() != inp_str2.length())
            return false;
        int[] charArr = new int[128];
        for(int i=0; i<inp_str1.length(); i++){
            int char_ascii = (int) inp_str1.charAt(i);
            charArr[char_ascii] = charArr[char_ascii] + 1;
        }
        for(int i=0; i<inp_str2.length(); i++){
            int char2_ascii = (int) inp_str2.charAt(i);
            charArr[char2_ascii] = charArr[char2_ascii] - 1;
            if(charArr[char2_ascii] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first input string : ");
        String inp_str1 = sc.next();
        System.out.println("Enter the second input string : ");
        String inp_str2 = sc.next();

        if(areTwoStringsPerm(inp_str1,inp_str2)){
            System.out.println("The two strings " + inp_str1 +  " and " + inp_str2 + " are equal.");
        }
        else
        {
            System.out.println("The two strings " + inp_str1 +  " and " + inp_str2 + " are not equal.");
        }
    }
}