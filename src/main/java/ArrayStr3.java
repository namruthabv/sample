/* Program to replace space in string with '%20' */
import java.util.Arrays;
import java.util.*;

public class ArrayStr3{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Enter the input string : ");
        String inp_str = sc.nextLine();
        System.out.println("String len : " + inp_str.length());
        System.out.println("Enter the total string length with value : ");
        int totalLen = sc.nextInt();

        int sp_cnt = 0;
        for(int i=0; i<totalLen; i++){
            if(inp_str.charAt(i) == ' ')
                sp_cnt = sp_cnt + 1;
        }
        int actLen = (sp_cnt * 2) + totalLen;
        System.out.println("acyLen len : " + actLen);

        char[] actualArr = new char[actLen];
        int trueLen = totalLen - 1;
        for(int i=actLen-1; i >=0; i--){
            if(inp_str.charAt(trueLen) == ' '){
                actualArr[i] = '0';
                actualArr[i-1] = '2';
                actualArr[i-2] = '%';
                i = i-2;
            }
            else{
                actualArr[i] = inp_str.charAt(trueLen);
            }
            trueLen = trueLen - 1;
        }

        System.out.println(String.valueOf(actualArr));
    }

}