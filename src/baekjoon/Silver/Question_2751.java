package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];
		
		for(int i=0;i<n;i++){
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<n;i++){
			bw.write(String.valueOf(numbers[i]));
			bw.newLine();
		}
		bw.flush();
	}
}
