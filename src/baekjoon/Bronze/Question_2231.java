package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean hasInit = false;

		int start = 0;
		
		if(n/ 100000 >=1) {
			start = n-54;
		}
		else if (n / 10000 >= 1) {
			start = n-45;
		}
		else if(n /1000 >= 1){
			start = n-36;
		}
		else if(n/100 >= 1) {
			start = n-27;
		}
		else if(n/10 >=1) {
			start = n-18;
		}
		else {
			start = n -9;
		}
		while(start != n) {
			int tmp;
			tmp = start + start/100000 + start%100000/10000 + start%10000/1000 + start%1000/100 + start%100/10 + start%10;
			if(tmp == n) {
				hasInit = true;
				break;
			}
			start++;
		}
		
		if(hasInit) 
			System.out.println(start);
		else
			System.out.println(0);
	}
}
