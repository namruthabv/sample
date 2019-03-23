// Find Number of reverse pairs in an array

// Link: https://algorithms.tutorialhorizon.com/find-number-of-reverse-pairs-in-an-array/

/* Given an array of integers A[],find no of reverse pairs means no of (i, j) pairs where i < j and A[i]>A[j]. */

public class TopHorArrRevPair{
    static int fin_res = 0;
    public static void main(String[] args){
        int[] inpArr = {10,3,4,2};
        new TopHorArrRevPair().findSol(inpArr, 0, inpArr.length-1);
        System.out.println("Final count of pairs : " + fin_res );
    }

    public void findSol(int[] inpArr, int low, int high){
        if(low == high)
            return;
        int mid = low + (high-low)/2;
        findSol(inpArr,low, mid);
        findSol(inpArr, mid+1, high);
        formArr(inpArr, low, mid, high);
    }

    public void formArr(int[] inpArr, int low, int mid, int high){
        int len1 = mid - low + 1;
        int len2 = high - mid;

        int[] left = new int[len1];
        int[] right = new int[len2];

        for(int i=0; i< len1; i++){
            left[i] = inpArr[low + i];
        }
        for(int j=0; j< len2; j++){
            right[j] = inpArr[mid + j +1];
        }

        fin_res += findPair(left, right);

        int index = low;
        int i=0;
        int j=0;

        for(int k=0; k<left.length; k++){
            if (left[i] <= right [j]){
                inpArr[index] = left[i];
                i++;
            }
            else{
                inpArr[index] = right[j];
                j++;
            }
            index ++;
        }

        while(i < len1){
            inpArr[index] = left[i];
            i++;
            index ++;
        }

        while(j < len2){
            inpArr[index] = left[j];
            j++;
            index ++;
        }
    }

    public int findPair(int[] left, int[] right){
        int res = 0;
        int start_fir = 0;
        int start_end = left.length-1;

        int end_fir = 0;
        int end_end = right.length-1;

        int i=start_fir;
        int j=end_fir;

        while(i<=start_end && j<=end_end){
            if(left[i] <= right[j]){
                i++;
            }
            else if(left[i] > right[j])
            {
                res+= start_end -i +1;
                j++;
            }
        }
        return res;
    }
}