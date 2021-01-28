/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {
	static int uf[];
	
	static int disjoint(int x) {
		if(x != uf[x]) return uf[x] = disjoint(uf[x]);
		else return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Node> Edges = new ArrayList<Node>();
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		uf = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			uf[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			Edges.add(new Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
		}
		
		Collections.sort(Edges);
		
		long ans = 0;
		
		for(int i = 0; i < m; i++) {
			int x = Edges.get(i).x, y = Edges.get(i).y;
			if(disjoint(x) != disjoint(y)) {
				uf[disjoint(y)] = uf[x];
				ans += Edges.get(i).z;
			}
		}
		System.out.println(ans);
	}
}

class Node implements Comparable<Node>{
	int x, y, z;
	
	public Node() {}
	public Node(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return this.z - arg0.z;
	}
	
}
*/