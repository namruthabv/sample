public class LinkedListCollision {
    public static void main(String[] args){

        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3= new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        LinkedListCollision lc = new LinkedListCollision();
        Node res = lc.detectcollision(head);
        System.out.println(res.value);
    }

    public Node detectcollision(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow.value == fast.value) {
                //return slow;
                break;
            }
        }


        if (fast == null || fast.next == null)
            return null;

        System.out.println("slow slow --" + slow.value);
        System.out.println("fast fast -- " + fast.value);
        slow = head;
        while(slow.value != fast.value){
            System.out.println("Fast --- " + fast.value);
            System.out.println("Slow --- " + slow.value);

            slow = slow.next;
            fast = fast.next;
        }

        return fast;


    }

}

