/* Implementation of Singly Linked List */


public class SinglyLinkedList<T> {
    int size;
    Node1<T> head;

    // Inserting node at starting pos 
    public void insertAtHead(T val){
        Node1<T> newNode = new Node1<T>(val);
        newNode.next = head;
        head = newNode;
        size ++;
    }

    // Inserting node at ending pos
    public void insertAtTail(T val){
        Node1<T> newNode = new Node1<T>(val);
        newNode.next = null;
        if(head == null){
            head = newNode;
        }
        else{
            Node1<T> tempNode = head;
            while(tempNode.next != null)
            {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size++;
    }

    public void insertAtPos(T val, int pos){
        if(pos < 0 || pos >= size){
            throw new IllegalArgumentException("Invalid size !!!");
        }
        Node1<T> newNode = new Node1<T>(val);
        if(pos == 0){
            newNode.next = head;
        }
        else{
            Node1<T> tempNode = head;
            for(int i=0; i<pos-1; i++){
                tempNode = tempNode.next;
            }
            Node1<T> nextNode = tempNode.next;
            tempNode.next = newNode;
            newNode.next = nextNode;
        }
        size ++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void traverse(){

        Node1<T> temp = head;
        while(temp != null){
            System.out.println("Node value : " + temp.value);
            temp = temp.next;
        }

    }

    public Node1<T> searchByInd(int ind){
        if(ind < 0 || ind >= size){
            throw new IllegalArgumentException("Invalid size !!!");
        }
        if(ind ==0)
            return head;
        Node1<T> temp = head;
        for (int i=0; i<ind; i++){
            temp = temp.next;
        }
        return temp;
    }

    public Node1<T> searchByVal(T val){
        Node1<T> temp = head;
        while(temp != null){
            if(temp.value == val)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void deleteFirst(){
        if(head == null){
            return;
        }
        head = head.next;
        size --;
    }

    public void deleteLast(){
        if(head == null){
            return;
        }
        else{
            Node1<T> currentNode = head;
            Node1<T> nextNode = currentNode.next;
            while(nextNode.next != null){
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
            currentNode.next = null;
        }
        size --;
    }

    public void deleteAtPos(int pos){
        if(pos < 0 || pos >= size){
            throw new IllegalArgumentException("Invalid size !!!");
        }
        if(pos == 0 ){
            deleteFirst();
        }
        else{
            Node1<T> currentNode = head;
            Node1<T> nextNode = currentNode.next;
            for(int i=0; i < pos-1; i++){
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode.next;
        }
        size --;
    }

    public Object[] linkedListtoArr(){
        Object[] res = new Object[size];
        Node1<T> currentNode = head;
        for(int i=0; i<size; i++){
            res[i++] = currentNode.value;
            currentNode = currentNode.next;
        }
        return res;
    }

    public static void main(String[] args){
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insertAtHead(1);
        sl.insertAtHead(2);
        sl.insertAtTail(3);
        sl.insertAtPos(5,2);
        sl.traverse();

        System.out.println("Printing val : " + sl.searchByInd(2));
        //sl.searchByInd(5);
        System.out.println("1-1-1-1-1 ");
        sl.traverse();
        sl.searchByVal(5);
        System.out.println("2-2-2-2-2-2 ");
        sl.traverse();
        System.out.println("Printing size : " + sl.size());

        sl.insertAtTail(9);
        sl.traverse();
        sl.deleteAtPos(2);
        System.out.println("gap gap ");
        sl.traverse();
        sl.deleteFirst();
        System.out.println("gap gap ");
        sl.traverse();

    }
}


class Node1<T>{
    T value;
    Node1<T> next;

    public Node1(T value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "Data value : " + value;
    }
}

