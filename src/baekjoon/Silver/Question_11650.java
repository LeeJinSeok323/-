package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Question_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String tmp;
		int[][] numbers = new int[n][2]; 
		int num1=0, num2=0;
		for(int i=0; i<n; i++) {
			tmp = br.readLine();
			int spaceIndex = tmp.indexOf(' ');
			num1 = Integer.parseInt(tmp.substring(0,spaceIndex));
			num2 = Integer.parseInt(tmp.substring(spaceIndex+1));
			numbers[i][0] = num1;
			numbers[i][1] = num2;
		}
		
		Arrays.sort(numbers, Comparator
			    .comparingInt((int[] arr) -> arr[0])
			    .thenComparingInt(arr -> arr[1])
			);
		
		
		for(int i=0; i<n; i++) {
			bw.write(numbers[i][0]+" "+numbers[i][1]);
			bw.newLine();
		}
		bw.flush();
		
	}
	
	
}
