
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//PART2-1. 매트릭스(행렬) 응용
public class BombCoverage {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in;
		FileWriter out;
		String str; 	//파일 입출력
		int testNumber;	//테스트케이스
		String arrNum[][] = new String[3][10];	//2차원 배열
		String cutStr[] = new String[3];		//파일 입출력
		String cutChar[][] = new String[30][30];//파일 입출력
		
		int num;	//배열 크기
		int size[] = new int[3];		//A,B,C형 폭탄 수
		int pt[][] = new int[3][50];	//A,B,C형 폭탄
		int ptx = 0, pty = 0;	//좌표 변수
		int i=0,j,k;	//반복문
		int remainder;	//남은 지역 수
		
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new FileWriter("output.txt");
			
			testNumber = Integer.valueOf(in.readLine());
			for(k=0;k<testNumber;k++) {
				Bomb bomb = new Bomb();	//객체생성
				num = Integer.valueOf(in.readLine());
				str = in.readLine();
				arrNum = new String[num][num];	//배열 크기 할당
				
				int startIndex = 0;
				for(i=0;i<3;i++) {	//위치 선정
					int fIndex = str.indexOf(",", startIndex);
					if (fIndex == -1)
						fIndex = str.length();
					cutStr[i] = str.substring(startIndex, fIndex);
					startIndex = fIndex+1;
				}
				
				for(i=0;i<3;i++) {
					size[i] = cutStr[i].length();
				}
				
				for(i=0;i<3;i++) {	// 좌표
					cutChar[i] = cutStr[i].split(" ");
				}
				
				for(i=0;i<3;i++) {
					for(j=0;j<=(size[i]-1)/2;j++) {
						pt[i][j] = Integer.valueOf(cutChar[i][j]);
					}
				}
				
				for(i=0;i<num;i++) {
					for(j=0;j<num;j++) {
						arrNum[i][j] = "0";
					}
				}
				
				System.out.print("#"+(k+1)+"\n"+" 지도의 크기 : "+num+"\n");
				System.out.print("폭탄이 떨어진 위치\n");
				
				for(i=0;i<3;i++) {
					System.out.printf("%c형 폭탄 : ", 65+i);
					for(j=0;j<=size[i]/2;j++) {
						System.out.print(pt[i][j]+" ");
					}
					System.out.println();
				}
					
				for(i=0;i<3;i++) {
					for(j=0;j<=size[i]/2;j++) {
						if(i==0) {
							if((i+j)%2 == 0)
								ptx = pt[i][j];
							else {
								pty = pt[i][j];
								arrNum[ptx][pty]="A";
							}
						}else if(i==1) {
							if((i+j)%2 == 0) {
								pty = pt[i][j];
								arrNum[ptx][pty]="B";
							} else 
								ptx = pt[i][j];
						}else {
							if((i+j)%2 == 0)
								ptx = pt[i][j];
							else {
								pty = pt[i][j];
								arrNum[ptx][pty]="C";
							}
						}
					}
				}
				
				for(i=0;i<num;i++) {
					for(j=0;j<num;j++) {
						System.out.print(arrNum[i][j]+" ");
					}
					System.out.println();
				}
				remainder = bomb.matrix(arrNum, num);	//함수 호출 후 남은 지역 수 반환
				out.write("#"+(k+1)+" "+remainder+"\r\n");
				System.out.print("커버되지 않은 지역의 수 : "+remainder+"\r\n");
			}	//end of for k
			in.close();
			out.close();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

class Bomb{
	boolean get(int i, int j, String arrNum[][], int num) {	//범위 체크 함수
		if(i<0 || j<0 || i>=num || j>=num)
			return false;
		return true;
	}
	
	int matrix(String arrNum[][], int num) {	//A,B,C형 폭탄의 범위계산
		int i,j;	//반복 인덱스
		int remainder = 0; //남은 지역 수
		
		for(i=0;i<num;i++) {
			for(j=0;j<num;j++) {
				switch(arrNum[i][j]) {
				case "C":	//C형 폭탄의 범위만큼 커버
					if(get(i-3, j, arrNum, num) && arrNum[i-3][j] == "0")
						arrNum[i-3][j] = "1";
					if(get(i, j-3, arrNum, num) && arrNum[i][j-3] == "0")
						arrNum[i][j-3] = "1";
					if(get(i+3, j, arrNum, num) && arrNum[i+3][j] == "0")
						arrNum[i+3][j] = "1";
					if(get(i, j+3, arrNum, num) && arrNum[i][j+3] == "0")
						arrNum[i][j+3] = "1";				
				case "B":	//B형 폭탄의 범위만큼 커버
					if(get(i-2, j, arrNum, num) && arrNum[i-2][j] == "0")
						arrNum[i-2][j] = "1";
					if(get(i, j-2, arrNum, num) && arrNum[i][j-2] == "0")
						arrNum[i][j-2] = "1";
					if(get(i+2, j, arrNum, num) && arrNum[i+2][j] == "0")
						arrNum[i+2][j] = "1";
					if(get(i, j+2, arrNum, num) && arrNum[i][j+2] == "0")
						arrNum[i][j+2] = "1";	
				case "A":	//A형 폭탄의 범위만큼 커버
					if(get(i-1, j, arrNum, num) && arrNum[i-1][j] == "0")
						arrNum[i-1][j] = "1";
					if(get(i, j-1, arrNum, num) && arrNum[i][j-1] == "0")
						arrNum[i][j-1] = "1";
					if(get(i+1, j, arrNum, num) && arrNum[i+1][j] == "0")
						arrNum[i+1][j] = "1";
					if(get(i, j+1, arrNum, num) && arrNum[i][j+1] == "0")
						arrNum[i][j+1] = "1";
				}
			}			
		}
		System.out.println();
		
		for(i=0;i<num;i++) {
			for(j=0;j<num;j++) {
				System.out.print(arrNum[i][j] + " ");
				if(arrNum[i][j] == "0") {
					remainder++;
				}
			}
			System.out.println();
		}
		return remainder;
	}
}