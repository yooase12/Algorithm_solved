import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1486 {

	static int ans, N, S;
	static int[] H;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			H = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
				H[i] = Integer.parseInt(st.nextToken());
			
			Search(0, 0);
			
			System.out.println("#" + tc + " " + ans);
			
		}

	}
	
	static void Search(int idx, int sum) {
		if(sum-S > ans) return;
		if(sum >= S) {
			ans = Math.min(ans, sum-S);
			return;
		}
		
		if(idx >= N) return;
		
		for(int i = idx; i < N; i++) {
			Search(i+1, sum+H[i]);
		}
	}

}
