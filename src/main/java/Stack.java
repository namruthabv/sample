import java.io.*;
import java.util.*;

public class Stack<T> {
    public class StackNode<T> {
        T data;
        StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }
    }

    StackNode<T> top;
    public static int size = 0;

    public void push(T item){
        StackNode st = new StackNode(item);
        st.next = top;
        top = st;
        size ++;
    }

    public T pop(){
        if(top == null)
            throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek(){
        if(top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public static void main(String[] args){
        Stack s = new Stack();
        //StackNode sn = new StackNode(1);
        s.push(2);
        s.push(3);
        System.out.println("Size of stack is : " + size);
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());

    }

}