package baekjoon.Silver;
import java.util.*;
import java.io.*;

public class Question_1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		

		Queue<Integer[]> q = new LinkedList<Integer[]>();
		if(k > n)
			q.add(new Integer[]{n, 0, 0});
		else {
			System.out.println(n-k);
			return;
		}
		int memo[] = new int[2*k+1];
		while(!q.isEmpty()) {
			Integer[] cur = q.poll();
			System.out.println(cur[1]+" "+ cur[0]);
			if(memo[cur[0]] != 0) {
				continue;
			}
			memo[cur[0]] = cur[1];
			if(cur[0] == k)
				break;
			else {
				if(cur[0]-1 > 0 && cur[2] != 1)
					q.add(new Integer[]{cur[0]-1, cur[1]+1, -1});
                if(cur[2] != -1 && cur[0]+1 <= k)
                	q.add(new Integer[]{cur[0]+1, cur[1]+1, 1});
                if(cur[0]*2 <= 2*k)
                	q.add(new Integer[]{cur[0]*2, cur[1]+1, 0});
			}	
		}
		System.out.println(memo[k]);
	}
	
}
