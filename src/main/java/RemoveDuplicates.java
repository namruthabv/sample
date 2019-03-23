import java.util.HashSet;

public class RemoveDuplicates{

    public static void main(String[] args){
        RemoveDuplicates li = new RemoveDuplicates();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        li.printinglinkedList(head);
        li.removeDup(head);
        System.out.println("----");
        li.printinglinkedList(head);

    }

    public void printinglinkedList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(" Node value : " + cur.value);
            cur = cur.next;
        }


    }

    /*
    public void removeDup(Node head){
        Node cur = head;
        HashSet<Integer> hs = new HashSet<Integer>();
        //HashSet<Integer> hs = new HashSet<Integer>();
        System.out.println("coming here");
        if(cur == null)
            return;
        hs.add(cur.value);
        Node nextNode = cur.next;
        while(nextNode != null){
            if(hs.contains(nextNode.value)){
                cur.next = nextNode.next;
            }
            else{
                hs.add(nextNode.value);
                cur = nextNode;
            }
            nextNode = nextNode.next;
        }
    }
    */

    /*
    public void removeDup(Node head){
        Node temp = head;

        HashSet<Integer> hs = new HashSet<Integer>();
        Node prev = null;
        //HashSet<Integer> hs = new HashSet<Integer>();
        System.out.println("coming here");
        while(temp != null){
            if(hs.contains(temp.value)){
                prev.next = temp.next;
            }
            else{
                hs.add(head.value);
                prev = temp;
            }
            temp = temp.next;
        }
        head = temp;
    }
    */

    public void removeDup(Node head){
        Node temp = head;
        while(temp!=null){
            Node nextNode  = temp;
            while(nextNode.next != null){
                if(temp.value == nextNode.next.value)
                    nextNode.next = nextNode.next.next;
                else
                    nextNode = nextNode.next;
            }
            temp = temp.next;
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

    @Override
    public String toString(){
        return "Data value : " + value;
    }
}
*/