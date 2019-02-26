import java.util.*;

public class Prog2 {

    public static void main (String[] args){
        int n = 12;
        //int[] ar = {1,2,1,2,1,3,2};
        int[] ar = {1,1,3,1,2,1,3,2,3,2,3,3};
        System.out.println(sockMerchant(n,ar));

    }

    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        int gr_cnt = 0;
        int cnt = 1;
        for(int i=0; i<n-1; i++){
            if(ar[i] == ar[i+1]){
                System.out.println(ar[i] + " - " + ar[i+1]);
                cnt = cnt+1;
            }
            else{
                System.out.println("In else" + gr_cnt);
                gr_cnt = gr_cnt + cnt/2;
                cnt = 1;
            }
            if(i == n-2){
                gr_cnt = gr_cnt + cnt/2;
            }
        }
        return gr_cnt;
    }
}
