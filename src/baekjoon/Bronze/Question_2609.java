package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question_2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()),
			b = Integer.parseInt(st.nextToken());
		
		if (a < b) {
			int c = a;
			a = b; b = c;
		}
		int c = 0;
		boolean isFind = false;
		int tempA = a, tempB = b;
		while(!isFind) {
			if(tempA % tempB == 0) {
				isFind = true;
				break;
			}
			c = tempA%tempB; tempA=tempB; tempB=c;
		}
		System.out.println(tempB);
		System.out.println(a*b/tempB);
		
	}
}
