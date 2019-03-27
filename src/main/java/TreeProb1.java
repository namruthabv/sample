import java.util.*;
import java.io.*;

public class TreeProb1{
    int V;
    LinkedList<Integer>[] adj;
    public static void main(String[] args){
        TreeProb1 g = new TreeProb1(4);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 3);

        boolean res = g.BFS_search(2,3);
        System.out.println("There is a route between 2 and 3 " + res );
    }
    public TreeProb1(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public boolean BFS_search(int root, int des){
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
                if(i == des){
                    return true;
                }
                if(marked[i] == false){
                    q.add(i);
                    marked[i] = true;
                }
            }
        }

        return false;
    }
}