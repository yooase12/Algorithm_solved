import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sw1227 {

	public static void main(String[] args) throws Exception{
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int []dx = {0, 0, 1, -1};
			int []dy = {1, -1, 0, 0};
			boolean [][]visited = new boolean[100][100];
			char [][]arr = new char[100][];
			
			String temp = br.readLine().trim();
			
			int sx = 0, sy = 0;
			for(int i = 0; i < 100; i++) {
				arr[i] = br.readLine().toCharArray();
				for(int j = 0; j < 100; j++) {
					if(arr[i][j] == '2') {
						sx = i;
						sy = j;
					}
				}
			}
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.offer(new int[]{sx,sy});
			
			while(!queue.isEmpty()) {
				int[] c = queue.poll();
				visited[c[0]][c[1]] = true;
				
				if(arr[c[0]][c[1]] == '3') {
					ans = 1;
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = c[0]+dx[i];
					int ny = c[1]+dy[i];
					
					if(nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && !visited[nx][ny] && arr[nx][ny] != '1' )
						queue.offer(new int[] {nx,ny});
				}
			}
			
			System.out.println("#" + temp + " " + ans);

		}

	}

}
