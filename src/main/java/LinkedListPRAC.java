import java.util.*;

public class LinkedListPRAC {
    public static void main(String[] args) {
        LinkedList alist = new LinkedList();
        alist.add(1);
        alist.add("hello");
        alist.add('c');
        alist.add(67);
        alist.add(2);
        System.out.println(alist);

        LinkedList<Integer>[] alist1 = new LinkedList[2];
        alist1[0] = new LinkedList();
        alist1[1] = new LinkedList();
        //alist1[2] = new LinkedList();

        alist1[0].add(3);
        alist1[0].add(2);
        alist1[0].add(4);
        List aa = alist.subList(1,5);
        System.out.println(aa);


        System.out.println("Printing  list : " + Arrays.toString(alist1[0].toArray()) );


        HashMap<Integer,String> cty = new HashMap<>();
        cty.put(1001, "India");
        cty.put(1002, "USA");
        cty.put(1003, "Australia");
        cty.put(1004, "Japan");

        for(Map.Entry kv : cty.entrySet()){
            System.out.println("Country num : " + kv.getKey() + " name : " + kv.getValue());
        }

        cty.remove(1003);
        System.out.println("\nAfter removing ------- \n");
        for(Map.Entry kv : cty.entrySet()){
            System.out.println("Country num : " + kv.getKey() + " name : " + kv.getValue());
        }
    }
}
