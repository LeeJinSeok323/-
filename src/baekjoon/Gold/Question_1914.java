package baekjoon.Gold;

import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Question_1914 {
	static int moveCount = 0;
	private static Queue<Integer> in = new LinkedList<>();
	private static Queue<Integer> out = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n > 20) 
			System.out.println(hugeHanoi(n));
		else{
			hanoi(n, 1, 2, 3);
            System.out.println(moveCount);
            for(int i=0; i<moveCount; i++) {
				System.out.println(in.poll()+" "+out.poll());
			}
        }
	}
	
	public static void hanoi(int n, int from, int via, int to) {
		if (n == 1) {
			in.add(from);
			out.add(to);
			moveCount++;
		}
		else {
			hanoi(n-1, from, to, via);
			in.add(from);
			out.add(to);
			moveCount++;
			hanoi(n-1, via, from, to);	
		}
		return;
	}
	public static BigInteger hugeHanoi(int n) {
		BigInteger big = BigInteger.valueOf(2).pow(n);
        BigInteger minus = BigInteger.valueOf(1);
        big = big.subtract(minus);
		return big;
	}
}
