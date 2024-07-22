package baekjoon.Silver;

import java.io.*;
public class Question_2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int goal = Integer.parseInt(br.readLine());
		
		if(goal != 4 && goal != 7)
			System.out.println(solution(goal));
		else{
			System.out.println(-1);
		}

		
	}
	
	public static int solution(int goal) {
		int rest = goal % 5;
		int answer = 0;
		
		switch (rest) {
		case 0:
			answer = goal / 5;
			break;
		case 1:
			answer = goal/5 +1;
			break;
		case 2:
			answer = goal /5 + 2;
			break;
		case 3:
			answer = goal/5 +1;
			break;
		case 4:
			answer = goal/5 +2;
			break;
		}
		
		return answer;
	}
}
