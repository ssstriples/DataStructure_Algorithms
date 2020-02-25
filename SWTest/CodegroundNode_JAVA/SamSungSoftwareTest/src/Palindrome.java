/*
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Palindrome {
	
	public static int reverse(int n) {
		int temp = n;
		int rev = 0;
		while(temp != 0) {
			rev = rev * 10 + temp % 10;
			temp /= 10;
		}
		return rev;
	}

	public static boolean isPalindrome(int[] arr, int cnt) {
		int start = 0;
		int end = cnt - 1;
		boolean flag = true;
		
		while(start <= end) {
			if(arr[start] != arr[end]) {
				flag = false;
				break;
			}
			else {
				start++;
				end--;
			}
		}
		return flag;		
	}
	
	public static int divN(int n, int cnt, int[] arr) {
		int temp = n;
		while (temp != 0) {
			arr[cnt] = temp % 10;
			temp /= 10;
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//BufferedReader in;
		//FileWriter out;
		
		int T;				//TestCase
		int N;				//Number
		
		int reverseN;		//Reverse Number
		int sum;			//Sum of Number and ReverseNum
		int arr[] = new int[10];
		int cnt;
		boolean flag = true;	//is or not Palindrome
			
		//in = new BufferedReader(new FileReader("PalindromeFiles/input.txt"));
		//out = new FileWriter("./PalindromeFiles/output.txt");
		
		//T = Integer.valueOf(in.readLine());
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(T-- != 0) {
			//N = Integer.valueOf(in.readLine());
			N = sc.nextInt();
			reverseN = 0;
			
			// 1. cal reverseNumber from input number
			reverseN = reverse(N);
			// 2. sum of inputNumber and reverseNumber
			sum = N + reverseN;
			// 3. save into arr, check each side of polar
			cnt = 0;
			cnt = divN(sum, cnt, arr);
			
			// 4. print yes or no by checking palindrome
			flag = isPalindrome(arr, cnt);
			if (flag == false) {
				//out.write("no\r\n");
				System.out.println("no");
			} else {
				//out.write("yes\r\n");
				System.out.println("yes");
			}
		}
		//in.close();
		//out.close();
	}
}
*/