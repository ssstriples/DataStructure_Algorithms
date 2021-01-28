/*
import java.util.Scanner;

public class Combinations {

	static int comb[][] = new int[1001][1001];	//comb[0][1] initialized with 0
	public static void cal_combination() {
		comb[0][0] = 1;
		for(int i = 1; i <= 1000; i++) {
			for(int j = 0; j <= i; j++) {
				if(j==0) {
					comb[i][j] = 1;
				} else {
					comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % 1000007;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cal_combination();
		
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while( q-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(comb[n][m]);
		}
	}
}
*/