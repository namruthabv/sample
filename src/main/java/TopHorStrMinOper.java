// Minimum Copy Paste Operations

// Link : https://algorithms.tutorialhorizon.com/minimum-copy-paste-operations/

/* Objective: You have given a character ‘A’ which is already printed. You are allowed to perform only 2 operations –

Copy All – This operation will copy all the printed characters.
Paste – This operation will paste all the characters which are already copied.
Given a number N, write an algorithm to print character ‘A’ exactly N times with minimum no of operations
 (either copy all or paste)

*/


public class TopHorStrMinOper{
    public static void main(String[] args){
        int N = 49;
        TopHorStrMinOper th = new TopHorStrMinOper();
        int res = th.minOper(N);
        System.out.println(res);
    }

    public int minOper(int num){
        int res = 0;
        for(int i=2; i<=num; i++){
            while(num%i == 0){
                res+=i;
                num = num/i;
            }
        }
        return res;
    }
}
