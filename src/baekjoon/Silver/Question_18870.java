package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer[] nums = new Integer[n];
		for(int i=0;i<n;i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Integer[] copy = Arrays.copyOf(nums, n);
		Arrays.sort(copy);
		int count = 0;
		int tmp = 1000000001;
		for(int i=0; i<n; i++) {
			if(copy[i] != tmp) {
				tmp = copy[i];
			}
			else {
				copy[i] = null;
				count++;
			}
		}
		int idx = 0;
		int[] copySorted = new int[n-count];
		
		for(int i=0;i<n;i++){
			if(copy[i] != null) {
				copySorted[idx] = copy[i];
				idx++;
			}
		}
		for(int i=0; i<n; i++) {
			bw.write(Arrays.binarySearch(copySorted, nums[i])+" ");
		}
		bw.flush();
		
		
		
		
		
	}
}
