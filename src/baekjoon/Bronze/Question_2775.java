package baekjoon.Bronze;

import java.io.*;
public class Question_2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int total=0;
			int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};

			for(int floor=1; floor <=k; floor++) {
				for(int j=0; j<n; j++) {
					total += arr[j];
					if (j == n-1 && i == k)
						break;
					arr[j] = total;
					//System.out.println("n은 " +j+ " total "+total+" arr["+j+"] : "+arr[j]);
				}
				if(floor != k)
					total = 0;
			}
			System.out.println(total);
		}
	}
}
