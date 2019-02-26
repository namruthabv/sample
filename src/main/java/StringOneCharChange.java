/* to check if only one character is being changed while comapared two strings */
import java.util.*;

public class StringOneCharChange{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String inp_str1 = sc.next();
        System.out.println("Enter second string : ");
        String inp_str2 = sc.next();
        boolean val = false;
        if(inp_str1.length() == inp_str2.length())
            val = isOneCharEdit(inp_str1, inp_str2);
        if(inp_str1.length() + 1  == inp_str2.length())
            val = isOneInsertRemove(inp_str1,inp_str2);
        if(inp_str1.length() - 1  == inp_str2.length())
            val = isOneInsertRemove(inp_str2,inp_str1);
        if(val)
            System.out.println("The two string have only one char difference ");
        else
            System.out.println("The two string does not have only one char difference ");
    }

    public static boolean isOneCharEdit(String inp_str1, String inp_str2){
        boolean isFalse = false;
        for(int i=0; i<inp_str1.length(); i++){
            if(inp_str1.charAt(i) != inp_str2.charAt(i))
                if(isFalse)
                    return false;
            isFalse = true;
        }
        return true;
    }

    public static boolean isOneInsertRemove(String inp_str1, String inp_str2){
        int in1 = 0;
        int in2 = 0;
        while(in1 < inp_str1.length() && in2 < inp_str2.length() ){
            if(inp_str1.charAt(in1) != inp_str2.charAt(in2)){
                if(in1 != in2){
                    return false;
                }
                in2 ++;
            }
            else{
                in1 ++;
                in2 ++;
            }
        }
        return true;
    }
}

