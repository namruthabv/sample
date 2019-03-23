/* Find a Number occurring odd number of times in a Given array */
/*
Link : https://algorithms.tutorialhorizon.com/find-a-number-occurring-odd-number-of-times-in-a-given-array/

Objective: Given a array of integers, in which every elements occurs even number of times except one number
 which occurs add number of times. Find out that number.

 */

public class TopHorArrFindingOddNum{
    public static void main(String[] args){
        int[] num = {1,1,2,2,3,3,3,4,4};
        int x = new TopHorArrFindingOddNum().solveOdd(num);
        System.out.println("Number that is repeating odd number of times is :" + x);
    }

    public int solveOdd(int[] num){
        int res = 0;
        for(int i=0; i<num.length; i++){
            res = res ^ num[i];
        }
        return res;
    }
}