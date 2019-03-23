// Print all sub sequences of a given array

// Link: https://algorithms.tutorialhorizon.com/print-all-sub-sequences-of-a-given-array/

/*  Given an array write an algorithm to print all the possible sub subsequences. */

public class TopHorArrSeqSet{
    public static void main(String[] args){
        int[] intArr = {1,2,3};
        int[] temp = new int[intArr.length];
        new TopHorArrSeqSet().solve(intArr, 0, temp);
        //System.out.println(val);
    }

    public void solve(int[] intArr, int ind, int[] temp){
        if(ind == intArr.length){
            printing(intArr, temp);
            return;
        }
        temp[ind] = 1;
        solve(intArr, ind+1, temp);
        temp[ind] = 0;
        solve(intArr, ind+1, temp);
    }

    public void printing(int[] inpArr, int[] temp){
        String res = " ";
        for(int i=0; i<inpArr.length; i++){
            if(temp[i] == 1){
                res += inpArr[i];
            }
        }
        if(res == " "){
            System.out.println("{ }");
        }
        System.out.println(res);
    }
}
