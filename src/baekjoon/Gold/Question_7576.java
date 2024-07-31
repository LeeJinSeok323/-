package baekjoon.Gold;

import java.util.*;
import java.io.*;
public class Question_7576 {
	static int[][] box;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] s = br.readLine().split(" ");
		int m = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		
		box = new int[n][m];
		int maxVisit = 0;
		Queue<Node> q = new LinkedList<Node>();
		
		
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				int tomato = Integer.parseInt(st.nextToken());
				box[i][j] = tomato;
				if(tomato == 0) {
					maxVisit++;
				}
				else if(tomato == 1) {
					q.add(new Node(j, i, 0));
				}
			}
		}
		int count = 0;
		Node node;
		int depth = -1;
		while(!q.isEmpty()) {
			node = q.poll();
			int x = node.getX(), y = node.getY();
			if(x-1 >= 0 && box[y][x-1] == 0) {
				box[y][x-1] = 1;
				q.add(new Node(x-1, y, node.getDepth()+1));
				count++;
			}
			if( x+1 < m && box[y][x+1] == 0) {
				box[y][x+1] = 1;
				q.add(new Node(x+1, y, node.getDepth()+1));
				count++;
			}
			if(y-1 >= 0 && box[y-1][x] == 0) {
				box[y-1][x] = 1;
				q.add(new Node(x, y-1, node.getDepth()+1));
				count++;
			}
			if(y+1 < n && box[y+1][x] == 0) {
				box[y+1][x] = 1;
				q.add(new Node(x, y+1, node.getDepth()+1));
				count++;
			}
			
			if(count == maxVisit) {
				depth = node.getDepth()+1;
				depth = depth == 1 ? 0 : depth; 
				break;
			}
		}
		
	
		System.out.println(depth);
	}
	
	
}
class Node {
	int x;
	int y;
	int depth;
	public Node(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth; 
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDepth() {
		return depth;
	}

}