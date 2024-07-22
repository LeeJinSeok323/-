package baekjoon.Silver;
//실버 5
import java.util.Scanner;
public class Question_1205 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 받기
		int n = sc.nextInt();
		int newScore = sc.nextInt();
		int p = sc.nextInt();
		sc.nextLine();
		
		// 문제 풀이
		int tmp = 0, pRank = -1;		
		boolean isRanked = false;
		for(int i=1; i<=n; i++) {
			tmp = sc.nextInt();
			if(tmp <= newScore && !isRanked ) {
				pRank = i;
				isRanked = true;
			}
		}
		if(pRank == -1 && n < p && tmp != newScore) {
			pRank = n + 1;
		}
		
		// 출력
		System.out.println(pRank);
	}
	
}
