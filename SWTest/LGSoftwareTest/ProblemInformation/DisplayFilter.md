# 1. 디스플레이 필터
## 1.1. 문제설명
- 디스플레이의 가시성을 높이기 위해서 얇은 필름형태의 필터를 개발 중이다.
- 최적의 성능을 낼 수 있도록 기본적으로 장착되어 나오는 필터 중 일부를 제거하여 성능을 향상시키려고 한다.

## 1.2. 부가 설명
- 디스플레이 개발팀에서는 디스플레이의 가시성 향상을 위해 얇은 필름 형태의 필터를 장착하기로 하였다.
- 필름은 외부 빛에 대해 반사 정도 R과 투과 정도 P의 특성을 가지며, 반사 정도는 **필터 각각의 반사 정도의 곱**이고 투과 정도는 **필터 각각의 투과 정도의 합**으로 나타낼 수 있다.
- 디스플레이에서 최적의 가시성을 확보하려면 반사 정도와 투과 정도가 조화를 이루어야 하며, **둘간의 차이가 최소**가 될수록 가시성이 높아진다.
- 그러나 디스플레이가 생산 될 때 N개의 필터가 장착되어 생산되므로 최적의 가시성을 확보하고 두께를 줄이기 위해서는 **불필요한 필터를 최대한 제거**할 필요가 있다.
- 최적의 가시성과 두께를 위해서 **제거해야 할 필터의 최대 개수**를 구하시오.
- 단, 디스플레이에는 **반드시 하나 이상의 필터**는 장착 되어야 한다.

## 1.3. 문제
### 1.3.1 입력 예시
- 다음과 같이 4개의 필터가 장착된 경우

|필터|반사 정도|투과 정도|
|:---:|:---:|:---:|
|1|2|10|
|2|2|8|
|3|3|4|
|4|4|12|
- 1번을 제거하면 반사 정도 2*3*4=24, 투과 정도는 8+4+12=24로 반사 정도와 투과 정도의 차가 0으로 가장 작아 진다.
- 최고의 성능을 내기 위해 제거해야 하는 필터의 개수를 구하시오.

### 1.3.2. 입력 형식
- 첫 번째 줄에는 장착된 필터의 수 N(N은 정수, 2<=N<=10)이 입력
- 두 번째 줄부터 N줄에 걸쳐 필터의 정보인 반사 정도 R(R은 정수, 1<=N<=20)과 투과 정도 P(P는 정수, 1<=N<=1,000,000)가 공백으로 구분되어 입력

### 1.3.3. 출력 형식
- 최고의 가시성과 두께를 위해 제거 해야 할 필터의 최대 개수를 출력

입력
<pre>
<code>
4
2 10
2 8
3 4
4 12
</code>
</pre>

출력
<pre>
<code>
1
</code>
</pre>

### 1.3.4. JAVA template
<pre>
<code>
import java.util.Scanner;
public class Main{
  int N;  //필터의 수
  int R[]=new int[11];  //반사의 정도
  int P[]=new int[11];  //투과의 정도

  void InputData(){
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    for (int i = 1; i<=N; i++){
      R[i] = sc.nextInt();
      P[i] = sc.nextInt();
    }
    sc.close();
  }

  public static void main(String[] args){
    int ans = -1;
    Main m = new Main();
    
    m.InputData();  //입력 함수
    
    // 코드를 작성하세요
    
    System.out.println(ans);  //출력
  }
}
</code>
</pre>