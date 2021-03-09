import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1219 {
	static class Node{
		int num;
		public Node l=null, r=null;
		public Node(int num) {
			super();
			this.num = num;
		}
		
	}
	
	static Node []tree;
	static int ans;

	public static void main(String[] args) throws Exception{
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int tp = Integer.parseInt(st.nextToken());
			int pathN = Integer.parseInt(st.nextToken());
			ans = 0;
			tree = new Node[100];
			for(int i = 0; i < 100; i++)
				tree[i] = new Node(i);
			
			//tree생성
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < pathN; i++) {
				int c = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if(tree[c].l == null) tree[c].l = tree[v]; //왼쪽 비었으면 왼쪽에
				else tree[c].r = tree[v]; // 아니면 오른쪽에 삽입.
			}
			
			Search(0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	static boolean Search(int idx) {
		//중위 탐색으로 값 찾음.
		if(idx == 99) { //도착지 찾았으면 탐색 종료.
			ans = 1;
			return true;
		}
		
		if(tree[idx].l != null) {
			if(Search(tree[idx].l.num)) return true;
		}
		if(tree[idx].r != null) {
			if(Search(tree[idx].r.num)) return true;
		}
		
		return false;
	}

}
