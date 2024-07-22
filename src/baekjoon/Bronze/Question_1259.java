package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Question_1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = 0;
		while(true) {
			String a = br.readLine();
			
			if( a.equals("0")) {
				break;
			}
			sb.append(a);
			sb.append(" ");
			count++;
		}
		StringTokenizer st = new StringTokenizer(sb.toString());
		for(int i=0; i<count; i++) {
			boolean isPalin = true;
			String num = st.nextToken();
			for(int j=0; j<num.length()/2; j++) {
				char x = num.charAt(j);
				int y = num.charAt(num.length()-1-j);
				if(x != y) {
					isPalin = false;
				}
			}
			if(isPalin) {
				System.out.println("yes");
			}
			else
				System.out.println("no");
		}
		
	}
}
