/* Find the local minima in a given array */
/*
Link : https://algorithms.tutorialhorizon.com/find-the-local-minima-in-a-given-array/

Objec­tive:  Given an array of integer write an algorithm to find the local minima.

Local Minima: An element is considered as local minima if it is less than both of its neighbors (if neighbors exist).

 */

public class TopHorArrBinarySearch {
    public static void main(String[] args){
        //int[] inpArr = {11, 4, 2, 5, 11, 13, 1};
        int[] inpArr = {11, 4, 2, 5, 11, 1, 5};
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