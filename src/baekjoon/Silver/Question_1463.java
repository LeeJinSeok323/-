package baekjoon.Silver;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Question_1463 {
	private static Queue<Integer> q = new LinkedList<>();
	private static int n, depth;
	private static int[] memo = new int[1000001];
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());	
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(n);
		q.add(1);
		depth = 0;
		Dp();
		System.out.println(depth);
	}
	public static void Dp() {
		do {
			Queue<Integer> tempQ = new LinkedList<>();
			
			while(!q.isEmpty()) {
				int i = q.poll();
	//			System.out.println(i+" "+n+"  Depth: "+depth);
				if(i == n) {
					return;
				}
				else if(i > n) {
					continue;
				}
				else if(memo[i] != 0){
					continue;
				}
				else 
				{
					tempQ.offer(i*3);
					tempQ.offer(i*2);
					tempQ.offer(i+1);
				}
				
				memo[i] = 1;
			}
			depth++;
			q = tempQ;
		}while(true);
	}
}
