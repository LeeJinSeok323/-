package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_11866 {
	static Queue<Integer> answer = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]),
			k = Integer.parseInt(tmp[1]);
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++){
			q.add(i);	
		}
		yosep(q, k);
		String s = answer.toString();
		s = s.substring(1, s.length()-1);
		System.out.println("<"+s+">");
	}
	
	public static void yosep(Queue<Integer> q, int k){
		while(!q.isEmpty()) {
			for(int i=0; i<k-1; i++) {
				q.add(q.poll());
			}
			answer.add(q.poll());
		}
		return;
	}
}






