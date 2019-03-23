// Print all substrings of a given string

// Link: https://algorithms.tutorialhorizon.com/print-all-substrings-of-a-given-string/

/*
Objec­tive:  Given a string write an algorithm to print all the possible sub strings.
 */



public class TopHorSubStr{
    public static void main(String[] args){
        String inpStr = "1234";
        new TopHorSubStr().subStringPrint(inpStr);
    }
    public void subStringPrint(String inpStr){
        for(int len=0; len<inpStr.length(); len++){
            for(int i = 0 ; i<inpStr.length()-len; i++){
                int j = i+len;
                for(int k=i; k<=j; k++){
                    System.out.print(inpStr.charAt(k));
                }
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}