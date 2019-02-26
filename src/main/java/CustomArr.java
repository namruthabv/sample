import java.util.*;
import java.util.Arrays;

public class CustomArr<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object elements[] = {};

    int size=0;

    public CustomArr(){
        elements = new Object[INITIAL_CAPACITY];
    }

    public void add(T elem){
        if(size == elements.length){
            ensureCapacity();
        }
        elements[size++] =  elem;
    }

    public boolean contains(T ele){
        if (ele ==null) throw new IllegalArgumentException("Invalid argument. cannot be null !!! ");
        for(Object e : elements){
            if(e == ele){
                return true;
            }
        }
        return false;
    }

    public Object remove(int index){
        Object removed_ele = elements[index];
        for(int i=index; i<size; i++){
            elements[i] = elements[i+1];
        }
        size--;
        return removed_ele;
    }

    public void ensureCapacity(){
        int newIncreasedArr = elements.length * 2;
        elements = Arrays.copyOf(elements, newIncreasedArr);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public void clearAll(){
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void display(){
        for(int i=0; i<size; i++){
            System.out.println("Index = " + i + "  Element = " + elements[i]);
        }
    }

    public static void main(String[] args){
        CustomArr<Integer> cusArr = new CustomArr<Integer>();
        cusArr.add(1);
        cusArr.add(4);
        cusArr.add(7);
        cusArr.display();
        System.out.println(cusArr.contains(4));
        System.out.println(cusArr.remove(1));
    }
}