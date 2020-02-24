/*
import java.util.*;

public class QUEUE {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String cmd = scanner.next();
			if(cmd.charAt(0) == 's') {
				System.out.println(q.size());
			}else if(cmd.charAt(0) == 'e') {
				int val = scanner.nextInt();
				q.add(val);
			}else if(cmd.charAt(0) == 'd') {
				q.remove();
			}else if(cmd.charAt(0) == 'f') {
				System.out.println(q.peek());
			}
		}
	}
}
*/
