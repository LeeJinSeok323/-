package baekjoon.Silver;
import java.util.*;
import java.io.*;
public class Question_2630 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		Queue<Square> q = new LinkedList<Square>();
		
		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int WCnt = 0, BCnt = 0;
		q.add(new Square(0,0, n));
		while(!q.isEmpty()) {
			Square s = q.poll();
			int x = s.getX();
			int y = s.getY();
			int length = s.length();
			boolean isDifferent = false;
			int startColor = map[y][x];
			
			for(int i=y;i<y+length;i++){
				
				for(int j=x;j<x+length;j++){
					if(map[i][j] != startColor)
						isDifferent = true;
				}
			}
			if(isDifferent) {
				q.add(new Square(x, y, length/2));
				q.add(new Square(x+length/2, y, length/2));
				q.add(new Square(x, y+length/2, length/2));
				q.add(new Square(x+length/2, y+length/2, length/2));
			}
			else {
				if(startColor == 1)
					BCnt++;
				else
					WCnt++;
			}
				
			
		}
		System.out.println(WCnt);
		System.out.println(BCnt);
	}
}

class Square{
	int x, y, length;
	boolean isPaintedAll;

	public Square(int x,int y, int length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}


	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int length() {
		return length;
	}
	
}