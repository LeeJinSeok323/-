package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question_1018 {
	static char[][] board;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(br.readLine());
		}
		board = new char[n*2-1][m*2-1];
		//board의 색을 i*2, j*2 번째에 저장
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				board[i*2][j*2] = sb.toString().charAt(i*8+j);
			}
		}
		memoPaints();
	
		
		for(int j=0;j<=(n-1)*2;j++){
			for(int i=0;i<=(m-2)*2;i++){
				System.out.print(board[j][i]+ " ");
			}
			System.out.println();
		}
		
	}
	public static int checkCountOfPaint(int startN,int startM) {
		
		if(n > startN+8 && m > startM+8) {
			checkCountOfPaint(startN+1,startM);
			checkCountOfPaint(startN, startM+1);
		}
		return 1;
	}
	public static void memoPaints() {
		//사이칸에 좌우 칸의 관계를 메모. 
		for(int i=1;i<(n-1)*2;i+=2){
			for(int j=1;j<(m-1)*2;j+=2){
				if(board[i-1][j-1] == board[i-1][j+1]) {
					board[i-1][j] = '0';
				}
				else {
					board[i-1][j] = '1';
				}
				if(board[i-1][j] == board[i+1][j]) {
					board[i][j-1] = '0';
				}
				else {
					board[i][j-1] = '1';
				}
			}
			// 위아래 관계는 8개를 검사해야함.
			if(board[i-1][(m-1)*2] == board[i+1][(m-1)*2]) {
				board[i][(m-1)*2] = '0';
			}
			else
				board[i][(m-1)*2] = '1';
		} 
		// 마지막줄 검사 해야함.
		for(int i=1;i<(m-1)*2;i+=2){
			if(board[2*(n-1)][i-1] == board[2*(n-1)][i+1]) {
				board[2*(n-1)][i] = '0';
			}
			else
				board[2*(n-1)][i] = '1';
			
		}
	}
}
