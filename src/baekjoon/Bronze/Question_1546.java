package baekjoon.Bronze;

import java.util.Scanner;
// 브론즈 1
public class Question_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine(); // \n 소비, nextInt는 숫자만 빼먹고 Enter Key로 입력된 \n을 지워주지 않음
		
		String scoresLine = sc.nextLine();
		String[] scores = scoresLine.trim().split("\\s+");
		
		// 최대 점수 구하기
		int maxScore = maxScore(scores);
		// 점수 조작 및 평균 구하기.
		float averageScore = 0;
		for(String score : scores) {
			float tmp = Integer.parseInt(score);
			averageScore += tmp/maxScore*100;
		}
		
		averageScore = averageScore / n;
		System.out.println(averageScore);
		
		
	}
	
	public static int maxScore(String[] scores) {
		int maxScore = 0;
		int tmpNum;
		for(String score : scores) {
			tmpNum = Integer.parseInt(score);
			if(maxScore < tmpNum) {
				maxScore = tmpNum;
			}
		}
		
		return maxScore;
	}
}