/* Magic Index – Find Index In Sorted Array Such That A[i] = i. */
/*
Link : https://algorithms.tutorialhorizon.com/magic-index-find-index-in-sorted-array-such-that-ai-i/

Objective: Given a sorted array of distinct integers, Find the Magic index or Fixed point in the array.

Magic Index or Fixed Point: Magic index or a Fixed point in an array is an index i in the array such that A[i] = i.

 */

public class TopHorArrBinarySearch {
    public static void main(String[] args){
        int[] inpArr = {11, 4, 2, 5, 11, 13, 1};
        int res = new TopHorArrBinarySearch().findLowNum(inpArr, 0, inpArr.length);
        System.out.println("The lowest element is : " + res);
    }

    public int findLowNum(int[] inpArr, int start, int end){
        int mid = start + (end - start)/2;
        if((mid == 0 || inpArr[mid-1] > inpArr[mid]) && (mid == inpArr.length-1 || inpArr[mid] < inpArr[mid+1]))
            return inpArr[mid];
        if(mid >0 && inpArr[mid] > inpArr[mid-1]){
            return findLowNum(inpArr, start, mid);
        }
        else{
            return findLowNum(inpArr, mid+1, end);
        }
    }

}