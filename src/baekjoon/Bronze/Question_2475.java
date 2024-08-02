package baekjoon.Bronze;

import java.util.*;
import java.io.*;
public class Question_2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int total = 0;
		for(int i=0;i<5;i++){
			int a = Integer.parseInt(st.nextToken());
			total += a*a;
		}
		
		total = total % 10;
		
		bw.write(String.valueOf(total));
		bw.flush();
		bw.close();
		br.close();
	}
}
