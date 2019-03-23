// Replace all vowels with next consonant in a given string

// Link: https://algorithms.tutorialhorizon.com/replace-all-vowels-with-next-consonant-in-a-given-string/

/*

Objective: Given a string, write an algorithm to replace all the vowels with next consonant,
and if last alphabet is vowel, remove it.
 */

public class TopHorStrVowelRep{
    public static void main(String[] args){
        TopHorStrVowelRep tp = new TopHorStrVowelRep();

        String inpSt1 = "abcdefee";
        String res = tp.replaceVowel(inpSt1);
        System.out.println(res);

        String inpSt2 = "aaaabbceeedddfiiuu";
        String res1 = tp.replaceVowel(inpSt2);
        System.out.println(res1);
    }

    public String replaceVowel(String inpStr){
        String res = "";
        String lastVisted = "\0";
        for(int i=inpStr.length()-1; i>=0; i--){
            if(isVowel(inpStr.charAt(i))){
                if(lastVisted != "\0"){
                    res = lastVisted + res;
                }
            }
            else{
                lastVisted = String.valueOf(inpStr.charAt(i));
                res = lastVisted + res;
            }
        }
        return res;
    }

    public boolean isVowel(char x){
        if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
            return true;
        }
        else{
            return false;
        }
    }
}