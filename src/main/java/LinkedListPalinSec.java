import java.awt.print.PrinterGraphics;
import java.util.Stack;

public class LinkedListPalinSec {
    public static void main(String[] args){
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        LinkedListPalinSec lp = new LinkedListPalinSec();;

        System.out.println(" The given list is palindrome : " + lp.isPalindrome(head));

    }

    public boolean isPalindrome(Node head){
        Node fast = head;
        Node slow = head;

        Stack<Integer> stk = new Stack<Integer>();

        while(fast != null && fast.next != null){
            stk.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null)
            slow = slow.next;

        while(slow != null){
            int top = stk.pop().intValue();
            if(slow.value != top){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
