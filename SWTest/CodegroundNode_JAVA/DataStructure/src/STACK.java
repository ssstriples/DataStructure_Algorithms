/*
import java.util.*;

public class STACK {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<N;i++) {
			String cmd = scanner.next();
			if(cmd.charAt(0) == 's') {
				System.out.println(st.size());
			}else if(cmd.charAt(0) == 'p') {
				if(cmd.charAt(1) == 'u') {
					int val = scanner.nextInt();
					st.push(val);
				}else if(cmd.charAt(1) == 'o') {
					st.pop();
				}
			}else if(cmd.charAt(0) == 't') {
				System.out.println(st.peek());
			}
		}
	}
}
*/
