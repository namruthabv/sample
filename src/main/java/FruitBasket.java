import java.util.HashMap;
import java.lang.Math;

public class FruitBasket{
    public static void main(String[] args){
        int[] trees = {1,2,3,2,2};
        FruitBasket fb = new FruitBasket();
        int res = fb.maxFruits(trees);
        System.out.println(res);
    }

    public int maxFruits(int[] trees){
        int i=0;
        int j=0;
        int max =1;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        while(j<trees.length){
            if(hm.size()<=2){

                hm.put(trees[j], j++);
                System.out.println("key , val : " + hm);
            }
            if(hm.size() > 2){
                int min = trees.length -1;
                System.out.println("min is: " + min);
                for(int k : hm.values()){
                    System.out.println("k val: " + k);
                    min = Math.min(min,k);
                    System.out.println("min secsec: " + min);
                }
                System.out.println(" removed : " + trees[min]);
                hm.remove(trees[min]);
                i = min + 1;
                System.out.println(" i : "  + i);
                System.out.println("key , val : " + hm);
            }
            max = Math.max(max,j-i);
        }
        return max;
    }
}