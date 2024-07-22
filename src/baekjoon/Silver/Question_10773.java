package baekjoon.Silver;

import java.io.*;
import java.util.*;
public class Question_10773 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());
			if(num == 0) {
				s.pop();
			}
			else {
				s.add(num);
			}
		}
		int size = s.size();
		int total = 0;
		for(int i=0; i<size; i++) {
			total += s.pop();
		}
		
		System.out.println(total);
	}
}
