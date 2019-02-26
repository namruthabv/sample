import java.util.*;

public class CompressingStr{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to be compressed : ");
        String pharse = sc.next();
        System.out.println(compressed(pharse));
    }

    public static String compressed(String pharse){
        StringBuilder compStr = new StringBuilder();
        int consCnt = 0; //for consecutive count

        for(int i=0; i<pharse.length(); i++){
            consCnt ++;
            if(i+1 >= pharse.length() || pharse.charAt(i) != pharse.charAt(i+1)){

                compStr.append(pharse.charAt(i));
                compStr.append(consCnt);
                consCnt = 0;
            }
        }
        return compStr.length() > pharse.length() ? pharse: compStr.toString();
    }

}