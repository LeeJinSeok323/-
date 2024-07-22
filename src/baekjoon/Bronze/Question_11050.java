package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question_11050 {
	static int n = 0, k = 0;
	static int[][] memo = {{}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		memo = new int[n+1][k+1];
		memo[n][k] = nCk(n,k);
		System.out.println(memo[n][k]);
	}
	
	public static int nCk(int n, int k) {
		if(k == 0 || k == n ) {
			return 1;
		}
		else {
			if(memo[n][k] == 0) {
				memo[n][k] = nCk(n-1,k) + nCk(n-1,k-1);
			}
			return memo[n][k];
			
		}
		
	}
}
