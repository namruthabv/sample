import java.io.*;
import java.util.*;

public class Queue<T> {
    public class QueueNode<T> {
        T data;
        QueueNode<T> next;
        public QueueNode(T data){
            this.data = data;
        }
    }

    QueueNode<T> first;
    QueueNode<T> last;
    public static int size = 0;

    public void add(T item){
        QueueNode q = new QueueNode(item);
        if(last != null)
            last.next = q;
        last = q;
        if(first == null)
            first = last;
        size ++;
    }

    public T delete(){
        if(first == null)
            throw new NoSuchElementException();
        T item = first.data;
        first = first.next;
        if(first == null)
            last = null;
        return item;
    }

    public T peek(){
        if(first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String[] args){
        Queue q = new Queue();
        //StackNode sn = new StackNode(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Size of queue is : " + size);
        System.out.println(q.delete());
        System.out.println(q.isEmpty());
        System.out.println(q.delete());
        System.out.println(q.isEmpty());
        System.out.println(q.delete());
        System.out.println(q.isEmpty());
    }

}