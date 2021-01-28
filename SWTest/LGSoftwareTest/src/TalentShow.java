/*
 * 
 * 	Codepro 제출 정답
 * 
 * 
 * */
/*
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TalentShow {
	int N;//직원 수
	int S;//시작 직원 번호
	int M;

	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); S = sc.nextInt(); M = sc.nextInt();
	}
	
	void calTSSequence(){
		List<Integer> list = new LinkedList<Integer>();
		List<Integer> orderedlist = new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			list.add(i+1);
		}
		
		while(!list.isEmpty()) {
			int start = list.indexOf(S);
			int end = (start+(M-1)) % list.size();
			//System.out.println("Start  : "+ start);
			//System.out.println("End  : "+ end);
			
			orderedlist.add(list.get(end));
			//System.out.println("olist : "+orderedlist);
			list.remove(end);
			//System.out.println("list : "+ list);
			if(list.size() == 0)
				break;
			S = list.get(end % list.size());
			//System.out.println("S : "+S);
		}
		
		//System.out.println(orderedlist);
		
		Iterator it = orderedlist.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}
	
	
	public static void main(String[] args) {
		TalentShow ts = new TalentShow();
		ts.InputData();//입력 함수
		
		//	코드를 작성하세요
		ts.calTSSequence();

	}
}
*/