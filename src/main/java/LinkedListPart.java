public class LinkedListPart {
    public static void main(String[] args){
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8)                    ;
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        System.out.println("coming here ....");

        LinkedListPart l = new LinkedListPart();
        Node p = l.printPartList(head,5);
        l.printingList(p);
    }

    public Node printPartList(Node head, int par){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        if (head == null)
            return null;

        while(head != null) {
            Node next = head.next;
            head.next = null;

            if (head.value < par) {
                if (beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            }
            else {
                if (afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    System.out.println("after else ---- : " + head.value);
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }

        if(beforeStart == null)
            return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;

    }

    public void printingList(Node  head){
        if(head==null)
            System.out.println("List is empty, better go home !!!");
        while(head != null){
            System.out.println("Node is : " + head.value);
            head = head.next;
        }
    }
}

class Node {
    int value;
    Node next;

    public Node(int value){
        this.value =value;
    }
}