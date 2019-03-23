//Magic Index – Find Index In Sorted Array Such That A[i] = i.

// Link: https://algorithms.tutorialhorizon.com/magic-index-find-index-in-sorted-array-such-that-ai-i/

/*
Objective: Given a sorted array of distinct integers, Find the Magic index or Fixed point in the array.

Magic Index or Fixed Point: Magic index or a Fixed point in an array is an index i in the array such that A[i] = i.
 */

public class TopHorTarAndInd{
    public static void main(String[] args){
        //int[] num = {-1,0,1,2,4,10};
        int[] num = {-1,0,2,3,6,10};
        int x = new TopHorTarAndInd().solveNum(num,0,num.length);
        System.out.println("The result is :" + x);
    }

    public int solveNum(int[] num, int start, int end){
        int res = -1;
        int mid = start + (end-start)/2;
        if(num[mid] == mid)
            return mid;
        if(num[mid] < mid)
            return solveNum(num,mid+1,end);
        if (num[mid] > mid)
            return solveNum(num,start,mid-1);
        return res;
    }
}