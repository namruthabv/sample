import java.util.*;
import java.io.*;

public class DFS{
    int V;
    LinkedList<Integer>[] adj;
    boolean[] marked;
    public static void main(String[] args){
        DFS g = new DFS(4);
        DFS h = new DFS(6);


        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


        h.addEdge(0, 1);
        h.addEdge(0, 2);
        h.addEdge(1, 3);
        h.addEdge(1, 4);
        h.addEdge(2, 4);
        h.addEdge(3, 4);
        h.addEdge(3, 5);
        h.addEdge(4, 5);

        System.out.println("Printing for G graph ");
        g.DFS_search(2);

        System.out.println("\n\nPrinting for H graph ");
        h.DFS_search(0);
    }
    public DFS(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
        marked = new boolean[v];
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    /*
    public void DFS_util(int root, boolean[] marked){
        marked[root] = true;
        System.out.print(root + " ");
        Iterator<Integer> itr = adj[root].listIterator();
            while(itr.hasNext()){
                int i = itr.next();
                if(marked[i] == false)
                    DFS_util(i,marked);
            }
    }
    
    public void DFS_search(){
        boolean[] marked = new boolean[V];
        //marked[root] = true;
        for(int i=0; i<V; i++){
            if(marked[i] == false)
                DFS_util(i,marked);
        }
    }
    */

    public void DFS_search(int root){
        //boolean[] marked = new boolean[V];
        marked[root] = true;
        System.out.print(root + " ");
        Iterator<Integer> itr = adj[root].listIterator();
        while(itr.hasNext()){
            int i = itr.next();
            if(marked[i] == false)
                DFS_search(i);
        }
    }

}