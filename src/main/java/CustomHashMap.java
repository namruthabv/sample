import java.util.Map;
import java.util.Set;
import java.util.Objects;
import java.util.*;

public class CustomHashMap<K,V> {

    public static void main(String[] args){
        CustomHashMap<String,Integer> map = new CustomHashMap<>();
        System.out.println("Creating a new Map, Size = " + map.size());
        System.out.println("Is Map Empty? => " + map.isEmpty());
        System.out.println("Adding a new Entry to Map.");
        map.put("Nammy", 10);
        System.out.println("Is Map Empty? => " + map.isEmpty());
        System.out.println("Size of Map => " + map.size());
        System.out.println("Does Map contains Key (Nammy)? => " + map.containsKey("Nammy"));
        System.out.println("Does Map contains Key (Nammy)? => " + map.containsKey("Nammy"));
        System.out.println("Does Map contains Value (10)? => " + map.containsValue(10));
        System.out.println("Get the value associated with Key (Nammy)? => " + map.get("Nammy"));
        System.out.println("Capacity of Map => " + map.capacity());
        System.out.println("Clearing the Map.");
        map.clear();
        System.out.println("Size of the Map after clearing. => " + map.size());
    }
    int threshold;
    float loadFactor;
    //int initialCapacity;
    static final int DEFAULT_INITIAL_CAPACITY = 15;
    static final int DEFAULT_MAX_CAPACITY = 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    transient int size;
    transient int modCount;
    transient Entry<K,V> table[];
    transient Set<Map.Entry<K,V>> entrySet;

    public CustomHashMap(int initialCapacity, float loadFactor){
        if(initialCapacity <= 0) {
            throw new IllegalArgumentException("Invalid initialCapacity capacity and it cannot be less then one !!!");
        }
        if(initialCapacity > DEFAULT_MAX_CAPACITY){
            initialCapacity = DEFAULT_MAX_CAPACITY;
        }
        if(loadFactor <= 0 || Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("Invalid Load capacity, cannot be less than one !!! ");
        }
        this.loadFactor = loadFactor;
        threshold = (int) (initialCapacity * loadFactor);
        table = new Entry[initialCapacity];
        init();
    }

    public CustomHashMap(int initialCapacity){
        this(initialCapacity,DEFAULT_LOAD_FACTOR);
    }

    public CustomHashMap(){
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
        init();
    }

    void init() { }

    private int hash(int h){
        h = h ^ (h >>> 12) ^ (h >>> 25);
        return h ^ (h >>>4) ^ (h >>> 3);
    }

    public int indexFor(int h, int length){
        return h & (length-1);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int capacity(){
        return table.length;
    }

    public void clear(){
        modCount ++;
        Entry<K, V> cloneTable[] = table;
        for(int i=0; i < cloneTable.length; i++){
            cloneTable[i] = null;
        }
        size = 0;
    }

    public V get(Object key){
        if(key == null){
            return getKeyForNull();
        }
        int hash = hash(key.hashCode());
        for(Entry<K,V> e=table[0]; e !=null; e = e.next){
            Object k;
            if(e.hash == hash && ((k = e.key) == key || key != null && key.equals(k))){
                return e.value;
            }
        }
        return null;
    }

    public V getKeyForNull(){
        for(Entry<K,V> e=table[0]; e != null; e = e.next){
            if(e.key == null)
                return e.value;
        }
        return null;
    }

    public boolean containsKey(Object key){
        return getEntryKey(key) == null;
    }

    public Entry<K,V> getEntryKey(Object key){
        int hash = (key == null) ? 0 : hash(key.hashCode());
        for(Entry<K,V> e=table[0]; e !=null; e = e.next){
            Object k;
            if(e.hash == hash && ((k = e.key) == key || key != null && key.equals(k))){
                return e;
            }
        }
        return null;
    }

    public boolean containsValue(Object value){
        for(int i=0; i<table.length; i++){
            for(Entry<K,V> e = table[0]; e != null; e=e.next){
                if(value != null && value.equals(e.value))
                    return true;
            }
        }
        return false;
    }

    public Object clone(){
        CustomHashMap<K,V> result = null;
        try{
            result = (CustomHashMap<K,V>)super.clone();
        }
        catch(CloneNotSupportedException e){

        }
        result.table = new Entry[table.length];
        result.size=0;
        result.modCount = 0;
        result.entrySet = null;
        result.init();
        result.putAllForCreate((Map<? extends K, ? extends V>) this);
        return result;

    }

    public void putAllForCreate(Map<? extends K, ? extends V> m){
        for(Map.Entry<? extends K, ? extends V> entry : m.entrySet()){
            int hash = (entry.getKey() == null) ? 0: hash(entry.getKey().hashCode());
            int index = indexFor(hash, table.length);
            for(Entry<K,V> e = table[index]; e != null; e = e.next ){
                Object k;
                if(e.hash == hash && ((k = e.key) == entry.getKey() ||  (entry.getKey() !=null  && entry.getKey().equals(k) ) )){
                    e.value = entry.getValue();
                    return;
                }
            }
            createEntrySet(hash, entry.getKey(), entry.getValue(), index);
        }
    }

    public V put(K key, V value){
        if(key == null){
            return putForNullKey(value);
        }
        else{
            int hash = hash(key.hashCode());
            int i = indexFor(hash, table.length);
            for(Entry<K,V> e = table[i]; e != null; e= e.next){
                Object k;
                if(e.hash == hash && ((k = e.key) == key || key.equals(k))){
                    V oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            modCount ++;
            addEntrySet(hash,key,value,i);
        }
        return null;
    }

    public V putForNullKey(V value){
        for(Entry<K,V> e = table[0]; e != null; e = e.next){
            if(e.key == null){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        modCount ++;
        addEntrySet(0,null,value,0);
        return null;
    }

    public void addEntrySet(int hash,K key, V value,int bucketIndex){
        Entry<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<K,V>(hash,key,value,e);
        if (size > threshold){
            resize(2 * table.length);
        }
    }

    public void createEntrySet(int hash,K key, V value,int bucketIndex){
        Entry<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<K,V>(hash,key,value,e);
        size ++;
    }

    public void resize(int newCapacity){
        Entry<K,V> oldTable[] = table;
        int oldCapacity = oldTable.length;
        if(oldCapacity == DEFAULT_MAX_CAPACITY){
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry<K,V> newTable[] = new Entry[newCapacity];
        transfer(newTable);
        threshold = (int) (newCapacity * loadFactor);

    }

    public void transfer(Entry<K,V>[] newTable){
        Entry<K,V>[] src = table;
        int newCapacity = newTable.length;
        for(int j=0; j<src.length; j++){
            Entry<K,V> e = src[j];
            if(e != null){
                src[j] = null;
                do{
                    Entry<K,V> next = e.next;
                    int i = indexFor(e.hash,newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while(e != null);
            }
        }
    }

    static class Entry<K,V>{
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next)  {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final boolean equals(Object o){
            if(this == o) return true;
            if(o instanceof Map.Entry ){
                Map.Entry<?,?> e = (Map.Entry<?,?>) o;
                if(Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }

        public final int hashCode(){
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}