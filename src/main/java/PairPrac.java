// Implementing the Pair data structure:

import java.util.*;

public class PairPrac<L,R> {

    public final L left;
    public final R right;

    public PairPrac(final L left,final R right )
    {
        super();
        this.left = left;
        this.right = right;
    }

    public static <L,R> PairPrac<L,R> of(final L left,final R right){
        return new PairPrac<>(left,right);
    }

    public L getLeft(){
        return left;
    }

    public R getRight(){
        return right;
    }

    public static PairPrac<String,Integer> getMaximum(ArrayList<PairPrac<String,Integer>> l){
        int maxScore = 0;
        PairPrac<String,Integer> ans = new PairPrac<String,Integer>(" ", 0);

        for(PairPrac<String,Integer> i : l){
            if(maxScore < i.getRight())
            {
                maxScore = i.getRight();
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        PairPrac p1 = new PairPrac(4,3);
        PairPrac p2 = new PairPrac(4,3);
        PairPrac p3 = new PairPrac(3,4);
        System.out.println("p1 == p2 : " + p1.equals(p2));

        ArrayList<PairPrac<String,Integer>> l = new ArrayList<PairPrac<String,Integer>>();
        l.add(new PairPrac("A",56));
        l.add(new PairPrac("B",73));
        l.add(new PairPrac("C",99));
        l.add(new PairPrac("D",64));
        l.add(new PairPrac("E",30));
        l.add(new PairPrac("F",98));
        PairPrac<String,Integer> ans = getMaximum(l);
        System.out.println("Student with highest score : " + ans.getLeft() + "and marks is " + ans.getRight());
    }
} 