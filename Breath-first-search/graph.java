import java.util.*;
class Graph{
	int v;
	LinkedList[] nodeArr;

	Graph(int V){
		v=V;
		nodeArr = new LinkedList[v];
	}

	public static void main(String[] args){
		Graph g = new Graph(4);
		//g.print();

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.BFS(2);
		//g.print();
	}

	public void print(){
		System.out.println("no of nodes in Graph="+this.v);
		for (int i=0; i < this.nodeArr.length; i++ ) {
			System.out.println("nodeArr="+this.nodeArr[i]);
		}
	}

	Boolean addEdge(int v, int n){
		if(this.nodeArr[v] == null){
			this.nodeArr[v] = new LinkedList<Integer>();
		}
		return this.nodeArr[v].add(n);
	}

	void BFS(int s){
		//boolean array to trace visited
		Boolean[] visited = new Boolean [this.v];

		//queue
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		q.add(s);
		visited[s]=true;
		
		while(q.size() !=0){
			s = q.poll();
			System.out.println("BFS node visit =" + s);
			
			//loop all child of ele
			Iterator<Integer> i = this.nodeArr[s].listIterator();
			while(i.hasNext()){
				int n = i.next();
				//System.out.println("n="+n+visited[n]);
				if(visited[n]==null || !visited[n]){
					//not visited
					q.add(n);
					visited[n]=true;
				}
			}//end while of linked list
		}// end of queue iterator
	}//end BFS
}