public class KToLast{
    public static void main(String[] args)
    {
        KToLast p = new KToLast();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(3);
        p.printKToLast(head,2);
    }

    /*
    public int printKToLast(Node head, int k){

        if(head == null)
            return 0;
        int ind = printKToLast(head.next, k) + 1;
        if(ind == k){
            System.out.println(k + " Printing Kth to last element " + head.value);
        }

        return ind;
    }
    */

    public void printKToLast(Node head, int k){
        int i=1;
        Node cur = head;
        if(cur == null)
            return;
        while(i<k){
            cur = cur.next;
            i = i+1;
        }
        while(cur != null){
            System.out.println("Printing node : " + cur.value);
            cur = cur.next;
        }
    }

}

/*
class Node<T>{
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "Data value : " + value;
    }
}
*/