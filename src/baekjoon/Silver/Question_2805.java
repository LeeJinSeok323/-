package baekjoon.Silver;
import java.util.*;
import java.io.*;
public class Question_2805 {
	static int[] woods;
	static long[] totals;
	static int count, max, goal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		woods = new int[n];
		int min = 2000000000; //나무 최대 길이
		max = 0;
		int total = 0;
		for(int i=0;i<n;i++){
			woods[i] = Integer.parseInt(st.nextToken());
			total += woods[i];
			if(min > woods[i])
				min = woods[i];
			if(max < woods[i])
				max = woods[i];
		}
		int h = 0;
		if(total - min*n <= goal) {
			total = total-min*n;
			for(int i=0;i<=min;i++){
				if(total + i*n >= goal) {
					h = min-i;
					break;
				}
			}
			System.out.println(h);
		}
		else {
			count = 0;
			totals = new long[max-min+1];
			System.out.println(topDown(max));
		}
		

	}
	public static int topDown(int height) {
		if(totals[max-height] >= goal)
			return height;
		for(int wood : woods) {
			if(wood == height) {
				count++;
			}
		}
		totals[max-height+1] = totals[max-height] + count;
		return topDown(height-1);
	}
}
