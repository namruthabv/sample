public class LinkedListPalindrome {
    public static void main(String[] args){
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        LinkedListPalindrome lp = new LinkedListPalindrome();
        Node p = lp.reverseList(head);
        lp.printingList(p);

        System.out.println(" The given list is palindrome : " + lp.isPalindrome(head, p));

    }

    public Node reverseList(Node node){
        Node tmp = null;
        if(node == null)
            return null;
        while(node != null){
            Node n = new Node(node.value);
            n.next = tmp;
            tmp = n;
            node = node.next;
        }
        return tmp;
    }

    public void printingList(Node  head){
        if(head==null)
            System.out.println("List is empty, better go home !!!");
        while(head != null){
            System.out.println("Node is : " + head.value);
            head = head.next;
        }
    }

    public boolean isPalindrome(Node fir, Node sec){
        while(fir != null && sec !=null){
            if(fir.value != sec.value)
                return false;

            fir = fir.next;
            sec = sec.next;
        }
        return fir == null && sec == null;
    }

}

/*
class Node1{
    int value;
    Node next;

    public Node1(int value){
        this.value = value;
    }
}
*/
