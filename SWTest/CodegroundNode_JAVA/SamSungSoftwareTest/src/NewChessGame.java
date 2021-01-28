/*
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NewChessGame {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in;
		FileWriter out;
		int testNum;		//Testcase
		String str;			//File I/O
		String chessBoard[][] = new String[3][10];
		String cutStr[] = new String[3];
		String cutChar[][] = new String[30][30];
		int num;			//2D Array Size
		int size[] = new int[3];	// A, B, C Type Queen Count
		int pt[][] = new int[3][50];	// A, B, C Type Queen location
		int ptx = 0, pty = 0;
		int i = 0,j,k;
		int remainder;
		try {
			in = new BufferedReader(new FileReader("NewChessGame/input.txt"));
			out = new FileWriter("NewChessGame/output.txt");
			
			testNum = Integer.valueOf(in.readLine());
			for(k=0; k < testNum; k++) {
				Chess chess = new Chess();
				num = Integer.valueOf(in.readLine());
				str = in.readLine();
				chessBoard = new String[num][num];
				int startIndex = 0;
				for (i=0; i < 3; i++) {
					int fIndex = str.indexOf(",", startIndex);
					if(fIndex == -1)
						fIndex = str.length();
					cutStr[i] = str.substring(startIndex, fIndex);
					startIndex = fIndex + 1;
				}
				
				for(i=0; i < 3; i++) {
					size[i] = cutStr[i].length();
				}
				
				for(i=0; i < 3; i++) {
					cutChar[i] = cutStr[i].split(" ");
				}
				
				for(i=0; i < 3; i++) {
					for(j=0; j <= (size[i]-1)/2; j++) {
						pt[i][j] = Integer.valueOf(cutChar[i][j]);
					}
				}
			
				for (i=0; i < num; i++) {
					for (j=0; j < num; j++) {
						chessBoard[i][j] = "0";
					}
				}
				
				System.out.print("#" + (k+1) + "\r\n");
				for(i=0; i < 3; i++) {
					System.out.printf("%cÇü Äý À§Ä¡ : ", 65+i);
					for(j=0; j <= (size[i]-1)/2; j++) {
						System.out.print(pt[i][j] + " ");
					}
					System.out.println();
				}
				
				for(i=0; i < 3; i++) {
					for(j=0; j <= (size[i]-1)/2; j++) {
						if(i == 0)
						{
							if((i+j)%2 == 0)
								ptx = pt[i][j];
							else {
								pty = pt[i][j];
								chessBoard[ptx][pty] = "A";
							}
						}
						else if(i == 1)
						{
							if((i+j)%2 == 0) {
								pty = pt[i][j];
								chessBoard[ptx][pty] = "B";	
							}
							else {
								ptx = pt[i][j];		
							}
						}
						else 
						{
							if((i+j)%2 == 0)
								ptx = pt[i][j];
							else {
								pty = pt[i][j];
								chessBoard[ptx][pty] = "C";
							}
						}
					}					
				}
				
				for (i=0; i < num; i++) {
					for (j=0; j < num; j++) {
						System.out.print(chessBoard[i][j] + " ");
					}
					System.out.println();
				}
				remainder = chess.matrix(chessBoard, num);
				out.write("#"+(k+1)+" "+remainder+"\r\n");
				System.out.print("ºóÄ­ÀÇ °³¼ö : "+remainder+"\r\n");				
			}
			in.close();
			out.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

class Chess {
	boolean get(int i, int j, String chessBoard[][], int num) {
		if(i<0 || j<0 || i>=num || j>=num)
			return false;
		return true;
	}
	
	int matrix(String chessBoard[][], int num) {
		int i, j;
		int remainder = 0;
		for(i=0;i<num;i++) {
			for(j=0;j<num;j++) {
				switch(chessBoard[i][j]) {
				case "C":
					if(get(i-3, j, chessBoard, num) && chessBoard[i-3][j] == "0")
						chessBoard[i-3][j] = "1";
					if(get(i, j-3, chessBoard, num) && chessBoard[i][j-3] == "0")
						chessBoard[i][j-3] = "1";
					if(get(i+3, j, chessBoard, num) && chessBoard[i+3][j] == "0")
						chessBoard[i+3][j] = "1";
					if(get(i, j+3, chessBoard, num) && chessBoard[i][j+3] == "0")
						chessBoard[i][j+3] = "1";
					if(get(i-3, j-3, chessBoard, num) && chessBoard[i-3][j-3] == "0")
						chessBoard[i-3][j-3] = "1";
					if(get(i+3, j+3, chessBoard, num) && chessBoard[i+3][j+3] == "0")
						chessBoard[i+3][j+3] = "1";
					if(get(i-3, j+3, chessBoard, num) && chessBoard[i-3][j+3] == "0")
						chessBoard[i-3][j+3] = "1";
					if(get(i+3, j-3, chessBoard, num) && chessBoard[i+3][j-3] == "0")
						chessBoard[i+3][j-3] = "1";
				case "B":
					if(get(i-2, j, chessBoard, num) && chessBoard[i-2][j] == "0")
						chessBoard[i-2][j] = "1";
					if(get(i, j-2, chessBoard, num) && chessBoard[i][j-2] == "0")
						chessBoard[i][j-2] = "1";
					if(get(i+2, j, chessBoard, num) && chessBoard[i+2][j] == "0")
						chessBoard[i+2][j] = "1";
					if(get(i, j+2, chessBoard, num) && chessBoard[i][j+2] == "0")
						chessBoard[i][j+2] = "1";
					if(get(i-2, j-2, chessBoard, num) && chessBoard[i-2][j-2] == "0")
						chessBoard[i-2][j-2] = "1";
					if(get(i+2, j+2, chessBoard, num) && chessBoard[i+2][j+2] == "0")
						chessBoard[i+2][j+2] = "1";
					if(get(i-2, j+2, chessBoard, num) && chessBoard[i-2][j+2] == "0")
						chessBoard[i-2][j+2] = "1";
					if(get(i+2, j-2, chessBoard, num) && chessBoard[i+2][j-2] == "0")
						chessBoard[i+2][j-2] = "1";					
				case "A":
					if(get(i-1, j, chessBoard, num) && chessBoard[i-1][j] == "0")
						chessBoard[i-1][j] = "1";
					if(get(i, j-1, chessBoard, num) && chessBoard[i][j-1] == "0")
						chessBoard[i][j-1] = "1";
					if(get(i+1, j, chessBoard, num) && chessBoard[i+1][j] == "0")
						chessBoard[i+1][j] = "1";
					if(get(i, j+1, chessBoard, num) && chessBoard[i][j+1] == "0")
						chessBoard[i][j+1] = "1";
					if(get(i-1, j-1, chessBoard, num) && chessBoard[i-1][j-1] == "0")
						chessBoard[i-1][j-1] = "1";
					if(get(i+1, j+1, chessBoard, num) && chessBoard[i+1][j+1] == "0")
						chessBoard[i+1][j+1] = "1";
					if(get(i-1, j+1, chessBoard, num) && chessBoard[i-1][j+1] == "0")
						chessBoard[i-1][j+1] = "1";
					if(get(i+1, j-1, chessBoard, num) && chessBoard[i+1][j-1] == "0")
						chessBoard[i+1][j-1] = "1";
				}
			}
		}
		System.out.println();
		for(i=0;i<num;i++) {
			for(j=0;j<num;j++) {
				System.out.print(chessBoard[i][j] + " ");
				if(chessBoard[i][j] == "0")
					remainder++;
			}
			System.out.println();
		}
		return remainder;
	}
}
*/