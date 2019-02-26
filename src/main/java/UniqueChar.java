import java.util.*;

public class UniqueChar{
    public static boolean UniqueChar(String inpStr){
        if(inpStr.length() > 128)
            return false;
        int charArr[] = new int[128];
        for(int i=0; i<inpStr.length(); i++){
            int ch_ascii = (int)inpStr.charAt(i);
            if(charArr[ch_ascii] != 0)
                return false;
            charArr[ch_ascii] = charArr[ch_ascii] + 1;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string to check if it contains unique characters.");
        String inp_str = sc.next();
        if(UniqueChar(inp_str)){
            System.out.println("The string " + inp_str + " contains unique characters.");
        }
        else
        {
            System.out.println("The string " + inp_str + " does not contains unique characters.");
        }
    }
}