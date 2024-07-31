package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] meetings = new int[n][2];
		for(int i=0;i<n;i++){
			meetings[i] = parseInts(br.readLine());
		}
		Arrays.sort(meetings ,new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				if(a[1] == b[1])
					return a[0] - b[0];
				return a[1] - b[1];
			}
		});
		
		int count = 0, idx = 0, cur = 0;
		
		for(int i=idx;i<n; i++) {
			if(cur <= meetings[i][0]) {
				cur = meetings[i][1];
				count++;
			}
		}
	
		System.out.println(count);
	}
	public static int[] parseInts(String str) {
		int[] a = new int[2];
		int idx = str.indexOf(" ");
		a[0] = Integer.parseInt(str.substring(0 , idx));
		a[1] = Integer.parseInt(str.substring(idx+1));
		
		return a;
	}
}
