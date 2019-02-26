import java.util.stream.*;
import java.util.Arrays;
import java.util.*;

public class PracStream{
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,3,1,2,6);
        System.out.println(numbers);
        List<Integer> square = numbers.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(square);

        List<String> words = Arrays.asList("Elite", "Keys", "Alpha", "Fancy", "Kite");
        List<String> sortedWrds = words.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedWrds);

        words.stream().filter(x->x.startsWith("K")).forEach(y->System.out.println(y));
        int val = numbers.stream().filter(x->(x%2)==0).reduce(0,(ans,i)->ans+i);
        System.out.println(val);

        Set<Integer> uniq = numbers.stream().collect(Collectors.toSet());
        System.out.println(uniq);
    }
}