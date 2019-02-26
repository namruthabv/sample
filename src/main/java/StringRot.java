/* Finding if st1 in a rotation of string str2 using subString method */
import java.util.Scanner;
import java.lang.String;

public class StringRot {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string : ");
        String inp_str1 = sc.next();
        System.out.println("Enter second string : ");
        String inp_str2 = sc.next();

        if(str1RotOFStr2(inp_str1,inp_str2)){
            System.out.println("The string str1 " + inp_str1 + " is rotation of str2 " + inp_str2);
        }
        else {
            System.out.println("Its not");
        }
    }

    public static boolean str1RotOFStr2(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        String str2str2 = str2 + str2;
        if(isSubString(str2str2,str1)){
            return true;
        }
        else
            return false;
    }

    public static boolean isSubString(String str2str2, String str1){
        return str2str2.indexOf(str1) >= 0;
    }
}