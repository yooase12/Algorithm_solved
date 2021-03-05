import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw8382 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()) + 100;
			int y1 = Integer.parseInt(st.nextToken()) + 100;
			int x2 = Integer.parseInt(st.nextToken()) + 100;
			int y2 = Integer.parseInt(st.nextToken()) + 100;
			if (x1 > x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}
			if (y1 > y2) {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}

			int small = Math.min(Math.abs(x1 - x2), Math.abs(y1 - y2));

			int rx = x2 - x1 - small;
			int ry = y2 - y1 - small;
			int r = rx + ry;

			int ans = small * 2;

			while (r > 0) {
				if (r > 1) {
					ans += 4;
					r -= 2;
				} else {
					ans += 1;
					r -= 1;
				}
			}

			System.out.println("#" + tc + " " + ans);

		}

	}

}
