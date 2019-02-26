// Program to print true if sum of two numbers is equal to target value
// Method 1: Brute force method with complexity n^2
// Method 2: Based on sorting algorithm
// Method 3: Based on Hashset  - O(n)  -- Most efficient
import java.io.*;
import java.util.*;
public class Prog1 {
    public static void main(String[] args){
        int inp_arr[] = {2,4,3,5,1};
        int tar = 5;
        //System.out.println(sum_of_two_numb(inp_arr,tar));
        sum_of_two_numb_method1(inp_arr,tar);                      // 1. Method 1 - Brute force
        sum_of_two_numb_method2(inp_arr,tar);                      // 2. Method 1 - Based on sorting algorithm
        sum_of_two_numb_method3(inp_arr,tar);                      // 3. Method 3 - Based on Hashset  - O(n)
    }
    // 1. Method 1 - Brute force
    public static void sum_of_two_numb_method1(int[] inp_arr, int tar){
        System.out.println("Method 1: Brute force");
        for(int i=0; i<inp_arr.length-1; i++){
            for(int j=i+1; j<inp_arr.length; j++){
                if(inp_arr[i] + inp_arr[j] == tar){
                    System.out.println("Two values " + inp_arr[i] + " " + inp_arr[j] + " equal : " + tar );
                }
            }

        }
        System.out.println();
    }

    // 2. Method 2 - Based on sorting algorithm
    public static void sum_of_two_numb_method2(int[] inp_arr, int tar){
        System.out.println("Method 2: Based on sorting algorithm");
        Arrays.sort(inp_arr);
           int i=0;
           int h=inp_arr.length-1;

           while (i < h){
               if(inp_arr[i] + inp_arr[h] < tar)
                   i ++;
               else if(inp_arr[i] + inp_arr[h] > tar)
                   h --;
               else {
                   System.out.println("Two values " + inp_arr[i] + " " + inp_arr[h] + " equal : " + tar );
                   i ++;
                   h --;
               }
           }
        System.out.println();
    }

    // 3. Method 3 - Based on Hashset  - O(n)
    public static void sum_of_two_numb_method3(int[] inp_arr, int tar){
        System.out.println("Method 3 - Based on Hashset  - O(n)");

        HashSet<Integer> s = new HashSet<Integer>();
        for(int i =0; i<inp_arr.length; i++){
            int temp = tar - inp_arr[i];
            if(temp > 0 && s.contains(temp)){
                System.out.println("Two values " + inp_arr[i] + " " + temp + " equal : " + tar );
            }
            else{
                s.add(inp_arr[i]);
            }

        }

    }
}