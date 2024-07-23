package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question_1018 {
	static ArrayList<Integer> paintCounts = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(br.readLine());
		}
		//임의로 B 을 true; W를 false로 지정한다.
		int paints[][] = new int[n][m];
		boolean startColor = true;
		for(int i=0;i<sb.toString().length(); i++){
			if(m%2 == 1) {// M이 홀수일때 i%2 ==0 은 무조건B i%2==1 은 무조건 W
				if(i%2 ==0 && sb.charAt(i) == 'B')
					paints[i/m][i%m] = 0;
				else if(i%2 ==1 && sb.charAt(i) == 'W')
					paints[i/m][i%m] = 0;
				else
					paints[i/m][i%m] = 1;
			}
			else {
				startColor = i%m == 0 ? !startColor : startColor;
				if(startColor) {
					if(i%2 ==0 && sb.charAt(i) == 'B')
						paints[i/m][i%m] = 0;
					else if(i%2 ==1 && sb.charAt(i) == 'W')
						paints[i/m][i%m] = 0;
					else
						paints[i/m][i%m] = 1;
				}
				else {
					if(i%2 ==0 && sb.charAt(i) == 'W')
						paints[i/m][i%m] = 0;
					else if(i%2 ==1 && sb.charAt(i) == 'B')
						paints[i/m][i%m] = 0;
					else
						paints[i/m][i%m] = 1;
				}
			}
		}
		// 갯수세기.
		for(int i=0;i<n-7;i++){
			for(int j=0;j<m-7;j++){
				countPaints(paints, j, i);
			}
		}
		
		
		Integer minCount = Collections.min(paintCounts);
		System.out.println(minCount);
	}
	public static void countPaints(int[][] paints, int x, int y) {
		int totalCnt = 0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				totalCnt += paints[y+i][x+j];
			}
		}
		paintCounts.add(totalCnt);
		paintCounts.add(64-totalCnt);
	}
}
