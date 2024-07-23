package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question_2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] cards = new int[n];
		boolean isChanged = false;
		boolean isTarget = true;
		int idx= 0;
		int target = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		while(true) {
			if(idx == n && !isChanged) {
				break;
			}
			else if(idx == n) {
				isChanged = false;
				idx = 0;
			}
			int card = cards[idx];
			
			if(card == 1) {
				idx++; continue;
			}
			else if(isTarget) {
				cards[idx] = 1; 
				isChanged = true;
			}
			else {
				target = idx+1;
			}
			isTarget = !isTarget;
			idx++;
		}
		System.out.println(target);
	}
}
