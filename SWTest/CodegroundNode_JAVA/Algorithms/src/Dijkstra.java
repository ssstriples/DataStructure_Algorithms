/*
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Dijkstra {
	static Vector<Vector<Edge>> edge;
	static int n;
	static int m;
	static int s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		s = scanner.nextInt();
		edge = new Vector<Vector<Edge>>();
		for(int i = 0; i < n+1; i++) {
			Vector<Edge> e = new Vector<Edge>();
			edge.add(e);
		}
		for(int i = 0; i < m; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			int d = scanner.nextInt();
			Edge e = new Edge(v,d);
			edge.elementAt(u).add(e);
		}
		Vector<Integer> dist = dijkstra(s);
		for(int i = 1; i < dist.size(); i++) {
			System.out.println(String.valueOf(dist.elementAt(i)));
		}
	}
	
	public static Vector<Integer> dijkstra(int cur){
		PriorityQueue<Edge> q = new PriorityQueue<>();
		Vector<Integer> dist = new Vector<Integer>();
		for(int i = 0; i < n+1; i++) {
			if(i==cur) {
				dist.add(0);
			} else {
				dist.add(-1);
			}
		}
		
		Edge e = new Edge(cur, 0);
		q.add(e);
		while(!q.isEmpty()) {
			Edge here = q.remove();
			for(int i = 0; i < edge.elementAt(here.dst).size(); i++) {
				Edge a = edge.elementAt(here.dst).elementAt(i);
				int there = a.dst;
				int nextdist = dist.elementAt(here.dst) + a.weight;
				if(dist.elementAt(there) == -1 || dist.elementAt(there) > nextdist) {
					dist.setElementAt(nextdist, there);
					Edge ne = new Edge(there, nextdist);
					q.add(ne);
				}
			}
		}
		
		return dist;
	}
}

class Edge implements Comparable<Edge> {
	int dst, weight;
	
	public Edge() {}
	public Edge(int dst, int weight) {
		this.dst = dst;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge arg0) {
		// TODO Auto-generated method stub
		return this.weight - arg0.weight;
	}
}
*/