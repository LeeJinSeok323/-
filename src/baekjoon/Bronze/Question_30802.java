package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question_30802 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size[] = new int[6];
		for(int i=0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		String amount[] = br.readLine().split(" ");
		int t = Integer.parseInt(amount[0]);
		int p = Integer.parseInt(amount[1]);
		
		int result = 0;
		for(int i : size) {
			if(i == 0) {
				continue;
			}
			else if(i < t) {
				result++;
			}
			else if(i%t == 0) {
				result += i/t;
			}
			else {
				result += i/t + 1;
			}
		}
		System.out.println(result);
		System.out.println(n/p +" "+ n % p);
	}
}
