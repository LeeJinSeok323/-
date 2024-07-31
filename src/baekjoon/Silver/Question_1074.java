package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_1074 {
	static int x, y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		System.out.println(checkBoundary(0,0, n));
		
	}
	
	public static int checkBoundary(int sx, int sy, int n) {
		int size = 1 << n-1;
		int boundary = -1;
		if( x <sx+size) {
			if(y <sy+size) {
				boundary = 0;
			}
			else {
				boundary = 2;
				sy = sy+size;
			}
		}
		else {
			if(y <sy+size) {
				boundary = 1;
				sx = sx+size;
			}
			else {
				boundary = 3;
				sx = sx+size;
				sy = sy+size;
			}
		}
		int result = 0;
		if(size != 1) {
			result = size*size* boundary + checkBoundary(sx, sy, n-1);
		}
		else
			return boundary;
		return result;
	}
}
