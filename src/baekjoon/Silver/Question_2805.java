package baekjoon.Silver;
import java.util.*;
import java.io.*;
public class Question_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] woods = new int[n];
		int max = 0;
		for(int i=0;i<n;i++){
			woods[i] = Integer.parseInt(st.nextToken());
			if(max < woods[i])
				max = woods[i];
		}
		
		int down = 0; 
		int up = max - goal/n;
		int mid = 0;
		long total = 0;
		while(down <= up) {
			mid = (down + up) /2;
			total = 0;
			for(int wood : woods) {
				if(wood > mid)
					total += wood-mid;
			}
			if(total > goal) {
				down = mid + 1;
			}
			else if(total < goal) {
				up = mid - 1;
			}
			else {
				break;
			}
		}
		total = 0;
		if(down > up) {
			for(int wood : woods) {
				if(wood > down)
					total += wood-mid;
			}
			if(total < goal) {
				mid = up;
			}
			
		}
		
		System.out.println(mid);

	}
	
}
