public class AddLinkedList{
    //Node head;

    public static void main(String[] args){
        AddLinkedList ad = new AddLinkedList();
        Node fir = new Node(7);
        fir.next = new Node(1);
        fir.next.next = new Node(6);

        Node sec = new Node(5);
        sec.next = new Node(9);
        sec.next.next = new Node(0);

        Node p = ad.sum2List(fir, sec);
        ad.printingList(p);
    }

    public Node sum2List(Node fir, Node sec){
        int sum = 0;
        int carry = 0;
        Node fin = new Node(0);
        fin.next = null;
        Node head = fin;
        while(fir != null){
            sum = fir.value + sec.value + carry;
            carry = 0;
            if(sum >= 10){
                Node temp = new Node(sum % 10);
                fin.next = temp;
                fin = fin.next;
                carry = sum / 10;
            }
            else{
                Node temp = new Node(sum);
                System.out.println("Coming here -- " + temp.value);
                fin.next = temp;
                fin = fin.next;

            }
            fir = fir.next;
            sec = sec.next;
        }
        return head;
    }

    public void printingList(Node  head){
        if(head==null)
            System.out.println("List is empty, better go home !!!");
        while(head.next != null){
            System.out.println("Node is : " + head.next.value);
            head = head.next;
        }
    }


}

/*
class Node{
    int value;
    Node next;

    public Node(int value){
        this.value = value;
    }
} */
