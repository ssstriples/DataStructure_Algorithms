
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//PART2-1. ��Ʈ����(���) ����
public class BombCoverage {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in;
		FileWriter out;
		String str; 	//���� �����
		int testNumber;	//�׽�Ʈ���̽�
		String arrNum[][] = new String[3][10];	//2���� �迭
		String cutStr[] = new String[3];		//���� �����
		String cutChar[][] = new String[30][30];//���� �����
		
		int num;	//�迭 ũ��
		int size[] = new int[3];		//A,B,C�� ��ź ��
		int pt[][] = new int[3][50];	//A,B,C�� ��ź
		int ptx = 0, pty = 0;	//��ǥ ����
		int i=0,j,k;	//�ݺ���
		int remainder;	//���� ���� ��
		
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new FileWriter("output.txt");
			
			testNumber = Integer.valueOf(in.readLine());
			for(k=0;k<testNumber;k++) {
				Bomb bomb = new Bomb();	//��ü����
				num = Integer.valueOf(in.readLine());
				str = in.readLine();
				arrNum = new String[num][num];	//�迭 ũ�� �Ҵ�
				
				int startIndex = 0;
				for(i=0;i<3;i++) {	//��ġ ����
					int fIndex = str.indexOf(",", startIndex);
					if (fIndex == -1)
						fIndex = str.length();
					cutStr[i] = str.substring(startIndex, fIndex);
					startIndex = fIndex+1;
				}
				
				for(i=0;i<3;i++) {
					size[i] = cutStr[i].length();
				}
				
				for(i=0;i<3;i++) {	// ��ǥ
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
				
				System.out.print("#"+(k+1)+"\n"+" ������ ũ�� : "+num+"\n");
				System.out.print("��ź�� ������ ��ġ\n");
				
				for(i=0;i<3;i++) {
					System.out.printf("%c�� ��ź : ", 65+i);
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
				remainder = bomb.matrix(arrNum, num);	//�Լ� ȣ�� �� ���� ���� �� ��ȯ
				out.write("#"+(k+1)+" "+remainder+"\r\n");
				System.out.print("Ŀ������ ���� ������ �� : "+remainder+"\r\n");
			}	//end of for k
			in.close();
			out.close();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

class Bomb{
	boolean get(int i, int j, String arrNum[][], int num) {	//���� üũ �Լ�
		if(i<0 || j<0 || i>=num || j>=num)
			return false;
		return true;
	}
	
	int matrix(String arrNum[][], int num) {	//A,B,C�� ��ź�� �������
		int i,j;	//�ݺ� �ε���
		int remainder = 0; //���� ���� ��
		
		for(i=0;i<num;i++) {
			for(j=0;j<num;j++) {
				switch(arrNum[i][j]) {
				case "C":	//C�� ��ź�� ������ŭ Ŀ��
					if(get(i-3, j, arrNum, num) && arrNum[i-3][j] == "0")
						arrNum[i-3][j] = "1";
					if(get(i, j-3, arrNum, num) && arrNum[i][j-3] == "0")
						arrNum[i][j-3] = "1";
					if(get(i+3, j, arrNum, num) && arrNum[i+3][j] == "0")
						arrNum[i+3][j] = "1";
					if(get(i, j+3, arrNum, num) && arrNum[i][j+3] == "0")
						arrNum[i][j+3] = "1";				
				case "B":	//B�� ��ź�� ������ŭ Ŀ��
					if(get(i-2, j, arrNum, num) && arrNum[i-2][j] == "0")
						arrNum[i-2][j] = "1";
					if(get(i, j-2, arrNum, num) && arrNum[i][j-2] == "0")
						arrNum[i][j-2] = "1";
					if(get(i+2, j, arrNum, num) && arrNum[i+2][j] == "0")
						arrNum[i+2][j] = "1";
					if(get(i, j+2, arrNum, num) && arrNum[i][j+2] == "0")
						arrNum[i][j+2] = "1";	
				case "A":	//A�� ��ź�� ������ŭ Ŀ��
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