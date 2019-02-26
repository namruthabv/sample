//Note tuples can have any number of elements we are implementing an triplets for now:
import java.util.*;

public class Tuples<L, M, R>{
    public final L left;
    public final M mid;
    public final R right;

    public Tuples(final L left, final M mid, final R right){
        super();
        this.left = left;
        this.mid = mid;
        this.right = right;
    }

    public static <L,M,R> Tuples<L,M,R> of(final L left, final M mid, final R right){
        return new Tuples<L,M,R>(left,mid,right);
    }

    public L getLeft(){
        return left;
    }

    public M getMid(){
        return mid;
    }

    public R getRight(){
        return right;
    }

    public static void main(String[] args){
        Tuples a = new Tuples(1,4,7);
        Tuples b = new Tuples(1,4,7);
        Tuples c = new Tuples(4,1,7);
        System.out.println("Tuples 'a' first, sec, and third values : " + a.getLeft() + "," + a.getMid() + "," + a.getRight() );
    }
}
