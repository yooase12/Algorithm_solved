import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj15684 {

	static boolean [][] map;
	static ArrayList<int[]> avail = new ArrayList<>();
	static int N, M, H, availN, ans = 4;
	static int lines[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new boolean[H+1][N+1]; //H가 가로선, N이 세로선
		lines = new int[N+1]; //세로선에 연결된 가로선 수
		
		//종단조건(줄 설치 수가 0일 경우)
		if(M == 0) {
			System.out.println("0");
			return;
		}
		
		//홀수 선이 3개 이상인 경우
		int check = 0;
		for(int j = 1; j <= N; j++) {
			if(lines[j] % 2 == 1) {
				check++;
			}
		}
		
		if(check>3) {
			System.out.println("-1");
			return;
		}
		
		//줄 입력
		int a = 0, b = 0;
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			lines[b]++;
			lines[b+1]++;
		}
		
		
		//줄 놓을 수 있는 공간 입력
		for(int i = 1; i <= H; i++) {
			for(int j = 1; j < N; j++) {
				if(isLineInstall(i,j)) {
					avail.add(new int[] {i,j});
				}
			}
		}
		
		availN = avail.size();
		
		Combination(0,0);
		if(ans < 4){
			System.out.println(ans);
		}
		else {
			System.out.println("-1");
		}
		
	}

	private static void Combination(int cnt, int start) {
		
		//현재 답보다 더 크면
		if(ans <= cnt) {
			return;
		}
		//도착 여부 확인
		if(isArrive()) {
			ans = Math.min(ans, cnt);
			return;
		}
		//아직 다 설치 못했다면
		else {
			for(int i = start; i < availN; i++) {
				int[] point = avail.get(i);
				if(isLineInstall(point[0], point[1])) {
					map[point[0]][point[1]] = true;
					lines[point[1]]++;
					lines[point[1]+1]++;
					Combination(cnt+1, i+1);
					map[point[0]][point[1]] = false;
					lines[point[1]]--;
					lines[point[1]+1]--;
				}
			}
		}
		return;
	}

	//i번째 줄이 i에 도착 여부 확인
	private static boolean isArrive() {
		int[] p = new int[N+1];
		
		//처음 시작 위치
		for(int i = 1; i <= N; i++)
			p[i]= i;
		
		//이동 시작
		for(int i = 1; i <= H; i++ ) {
			for(int j = 1; j < N; j++) {
				//만약에 선이 있다면 교체
				if(map[i][j]) {
					int temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
				}
			}
		}
		
		//도착 위치 확인
		for(int i = 1; i <= N; i++) {
			if(p[i] != i) return false;
		}
		return true;
	}

	//줄 설치 여부
	private static boolean isLineInstall(int a, int b) {
		if(map[a][b]) return false; //현재 위치에 이미 설치되어 있다면 설치 불가
		else if(map[a][b-1]) return false; //설치 기준으로 왼쪽에 설치되어있으면 설치 불가
		else if(map[a][b+1]) return false; //설치 기준으로 오른쪽에 설치되어 있다면 설치 불가
		return true;
	}

}
