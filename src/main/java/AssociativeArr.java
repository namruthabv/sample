// Associative array implementation
import java.util.*;
import java.lang.*;


public class AssociativeArr<K,V> {
    int capacity;
    EntryValue<K,V>[] table;

    public AssociativeArr(int capacity){
        this.capacity = capacity;
        table = new EntryValue[capacity];
    }

    public class EntryValue<K,V>{
        K key;
        V value;
        EntryValue next;

        public EntryValue(K key, V value, EntryValue next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K newKey, V data){

        EntryValue<K,V> newEntry = new EntryValue(newKey,data,null);

        if(newKey == null)
            return;
        int hashval = hash(newKey);
        if(table[hashval] == null)
            table[hashval] = newEntry;
        else{
            EntryValue<K,V> cur = table[hashval];
            EntryValue<K,V> prev = null;
            while(cur != null){
                if(cur.key.equals(newKey)){
                    if(prev != null){
                        newEntry.next = cur.next;
                        table[hashval] = newEntry;
                        return;
                    }
                    else{
                        newEntry.next = cur.next;
                        prev.next = newEntry;
                        return;
                    }
                }
                prev = cur;
                cur = cur.next;
            }
            prev.next = newEntry;
            //cur = newEntry;
        }

    }

    public V get(K keyval){
        if(keyval == null)
            return null;
        int hashval = hash(keyval);
        if(table[hashval] == null)
            return null;
        else{
            EntryValue<K,V> cur = table[hashval];
            while(cur != null){
                if(cur.key.equals(keyval))
                    return cur.value;
                cur = cur.next;
            }
            return null;
        }
    }

    public void display(){
        System.out.println("Coming here .....");
        for(int i=0; i<capacity; i++){
            if(table[i] != null){
                EntryValue<K,V> cur = table[i];
                while(cur != null){
                    System.out.println("{" + cur.key + "=" + cur.value + "}");
                    cur = cur.next;
                }
            }
        }
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    public static void main(String[] args){
        AssociativeArr<Integer,String> myAsso = new AssociativeArr<Integer,String>(4);
        myAsso.put(1,"Arjun");
        myAsso.put(2,"Bhargav");
        myAsso.put(3,"Namratha");
        System.out.println(myAsso.get(2));
        //myAsso.get(2);
        myAsso.display();
    }
}