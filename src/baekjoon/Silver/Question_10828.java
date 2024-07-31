package baekjoon.Silver;

import java.util.*;
import java.io.*;

public class Question_10828 {
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int tmp;
		for(int i=0;i<n;i++){
			tmp = stackRequest(br.readLine());
			if(tmp != -9)
				bw.write(tmp+ "\n");
		}
		bw.flush();
		
		
		
	}
	public static int stackRequest(String request) {
		// s:push p:pop z:size
		char c = request.charAt(0);
		switch(c) {
		case 'p':
			c = request.charAt(1);
			if(c == 'u'){
				stack.push(Integer.parseInt(request.substring(5)));
				return -9;
			}
			else
				return stack.isEmpty() ? -1 : stack.pop();
		case 's':
			return stack.size();
		case 'e':
			return stack.isEmpty() ? 1 : 0;
		case 't':
			return stack.isEmpty() ? -1 : stack.peek();
		}
		
		
		return -9;
	}
}
