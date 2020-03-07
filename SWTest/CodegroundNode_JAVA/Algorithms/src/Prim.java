/*
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
	//int v[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		ArrayList<Node> g[] = new ArrayList[10005];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for(int i = 1; i <= n; i++) {
			g[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int z = scanner.nextInt();
			g[x].add(new Node(y, z));
			g[y].add(new Node(x, z));
		}
		
		int s = 1, ans = 0;
		int v[] = new int[n+1];
		
		for(int i = 0; i < n-1; i++) {
			v[s] = 1;
			for (int j = 0; j < g[s].size(); j++) {
				pq.add(g[s].get(j));
			}
			
			while(v[pq.peek().x] == 1) {
				pq.remove();
			}

			ans += pq.peek().y;
			s = pq.peek().x;
			pq.remove();
		}
		System.out.println(ans);
		scanner.close();
	}
}

class Node implements Comparable<Node>{
	int x, y;
	
	public Node() {}
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.y - o.y;
	}
}
*/