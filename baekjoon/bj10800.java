import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class data implements Comparable<data>{
		int idx, color, size;

		public data(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}

		@Override
		//정렬 기준
		public int compareTo(data o) {
			return this.size - o.size; //size크기로 오름차순
		}
		
	}
	
	static PriorityQueue<data> ball = new PriorityQueue<>();
	static Queue<data> sameBall = new LinkedList<>();
	static StringTokenizer st;
	static int N , lastSum, lastSize;
	static int[] ans, colorSum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = new int[N]; //정답 넣을 배열
		colorSum = new int[N+1]; //색 누적 배열.
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			ball.offer(new data(i,color,size));
		}
		
		while(!ball.isEmpty()) {
			data t = ball.poll();
			
			if(lastSize != t.size) { //현재 사이즈가 전 사이즈랑 다르면 반영 후 계산
				while(!sameBall.isEmpty()) { //쌓인 데이터 방출.
					data sameB = sameBall.poll();
					colorSum[sameB.color] += sameB.size;
					lastSum += sameB.size;
				}
			}
			ans[t.idx] = lastSum - colorSum[t.color]; //누적 합 - 같은 색
			sameBall.offer(t);
			lastSize = t.size;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(ans[i] + "\n");
		}
		System.out.println(sb);
	}

}
