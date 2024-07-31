package baekjoon.Silver;

import java.util.*;
import java.io.*;

public class Question_1003 {
	static Map<Integer, Integer[]> memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		memo = new HashMap<Integer, Integer[]>();
		int num;
		memo.put(0, new Integer[]{1, 0});
		memo.put(1, new Integer[]{0, 1});
		for(int i=0;i<n;i++){
			num = Integer.parseInt(br.readLine());
			Integer[] result = fibonacci(num);
			bw.write(result[0] + " " + result[1] + "\n");
		}
		bw.flush();
	}
	
	public static Integer[] fibonacci(int number) {
		if(memo.get(number) != null)
			return memo.get(number);
		else {
			Integer[] a = fibonacci(number-1).clone();
			Integer[] b = fibonacci(number-2);

			a[0] += b[0];
			a[1] += b[1];
			
			memo.put(number, a);
			return a;
		}
	}
}
