package graph;
import java.util.*;

class Graph{
    int v;
    LinkedList[] nodes;

    Graph(int V){
        v=V;
        nodes = new LinkedList[v];
    }

    void addNode(int n, int x){
        //create new linked list
        if(nodes[n]==null) nodes[n] = new LinkedList<Integer>();
        //add node
        nodes[n].add(x);
    }

    void bfs(int n){
        ArrayList<Integer> q = new ArrayList<Integer>();
        q.add(n);
        while(q.size() > 0){
            int ele = q.remove(0);
            System.out.println(ele);

            if(this.nodes[ele] == null) continue;

            Iterator it = this.nodes[ele].iterator();
            while(it.hasNext()){
                int nt = (Integer) it.next();
                q.add(nt);
            }
        }
    }

    boolean dfs(int n){
        System.out.println(n);
        if(this.nodes[n]==null) return false;
        Iterator it = this.nodes[n].iterator();
        while(it.hasNext()){
            int ele = (Integer) it.next();
            dfs(ele);

        }
        return true;
    }
}

public class GraphDemo {
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addNode(0, 1);
        g.addNode(0, 2);
        g.addNode(1, 5);
        g.addNode(1, 4);
        g.addNode(2, 3);
        g.addNode(2, 6);
        g.addNode(3, 7);

        //g.bfs(0);
        g.dfs(0);
    }
}
