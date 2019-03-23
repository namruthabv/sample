import java.util.*;
import java.io.*;

public class BFS{
    int V;
    LinkedList<Integer>[] adj;
    public static void main(String[] args){
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS_search(2);
    }
    public BFS(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void BFS_search(int root){
        boolean[] marked = new boolean[V];
        //Queue q = new Queue();
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(root);
        marked[root] = true;
        while(q.size() != 0){
            int d = q.poll();
            System.out.print( d + " ");
            Iterator<Integer> itr = adj[d].listIterator();
            while(itr.hasNext()){
                int i = itr.next();
                if(marked[i] == false){
                    q.add(i);
                    marked[i] = true;
                }
            }
        }
    }
}