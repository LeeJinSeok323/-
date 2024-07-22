package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while(true) {
			String line = br.readLine();
			if(line.equals("0 0 0"))
				break;
			sb.append(line);
			sb.append(" ");
			count++;
		}
		StringTokenizer st = new StringTokenizer(sb.toString());
		
		for(int i=0; i<count; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			boolean isRight = false;
			if(a > b && a > c) {
				isRight = a*a == b*b + c*c;
			}
			else if(b > c && b > a) {
				isRight = b*b == a*a + c*c;
			}
			else if(c > a && c > b) {
				isRight = c*c == a*a + b*b;
			}
			
			if(isRight) {
				System.out.println("right");
			}
			else
				System.out.println("wrong");
		}
		
	}
}
