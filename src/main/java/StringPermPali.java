/* java program to check if the permutation of given string is a palindrome or not */
import java.util.*;

public class StringPermPali{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Enter the string that has to checked : ");
        String inp_str = sc.next();
        int[] table = charOccurence(inp_str);
        boolean isPalindrome = isPalindrome(table);
        if(isPalindrome)
            System.out.println(" The given string is palindrome ");
        else
            System.out.println(" The given string is not palindrome ");
    }


    public static int[] charOccurence(String inp_str){
        int tab[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char i : inp_str.toCharArray()){
            int x = getCharValue(i);
            if(x != -1)
                tab[x]++;
        }
        return tab;
    }

    public static int getCharValue(char val){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int c = Character.getNumericValue(val);
        if(a <= c && c <= z)
            return c-a;
        return -1;
    }


    public static boolean isPalindrome(int[] table){
        boolean isFound = false;
        for(int i : table){
            if(i % 2 == 1){
                if(isFound)
                    return false;
                isFound = true;
            }
        }
        return true;
    }
}
