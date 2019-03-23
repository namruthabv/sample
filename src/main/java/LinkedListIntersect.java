import java.lang.Math;
import java.net.SocketTimeoutException;

public class LinkedListIntersect {
    public static void main(String[] args){
        Node fir = new Node(3);
        fir.next = new Node(1);
        fir.next.next = new Node(5);
        fir.next.next.next = new Node(9);
        fir.next.next.next.next = new Node(7);
        fir.next.next.next.next.next = new Node(2);
        fir.next.next.next.next.next.next = new Node(1);

        Node sec = new Node(4);
        sec.next = new Node(6);
        sec.next.next = new Node(7);
        sec.next.next.next = new Node(2);
        sec.next.next.next.next = new Node(1);
        LinkedListIntersect inter = new LinkedListIntersect();

        Node res = inter.getIntersect(fir,sec);
        if(res == null){
            System.out.println("Its NULLLL ---- ");
        }
        else {
            System.out.println(res.value);
        }

    }

    public Result getTailSize(Node cur){
        if(cur == null)
            return null;
        int size = 1;
        Node tmp = cur;
        while(tmp.next != null){
            size ++;
            tmp = tmp.next;
        }
        return new Result(tmp,size);

    }

    public Node getKNode(Node longer, int k){
        Node cur = longer;
        while(k > 0 && cur != null){
            cur = cur.next;
            k --;
        }
        return cur;
    }


    public Node getIntersect(Node fir, Node sec){
        if(fir == null && sec == null)
            return null;

        Result firRes = getTailSize(fir);
        Result secRes = getTailSize(sec);

        if(firRes.tail.value != secRes.tail.value){
            return null;
        }


        Node shorter = firRes.size < secRes.size ? fir : sec;
        Node longer = firRes.size <= secRes.size ? sec : fir;

        longer = getKNode(longer, Math.abs(firRes.size-secRes.size));

        while(shorter.value != longer.value){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;

    }



}

class Result {
    Node tail;
    int size;

    public Result(Node tail, int size) {
        this.tail = tail;
        this.size = size;
    }

}

