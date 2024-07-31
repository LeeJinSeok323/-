package baekjoon.Silver;
import java.util.*;
import java.io.*;
public class Question_14940 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int maxVisit = 0;
		Queue<Node> q = new LinkedList<Node>();
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				int place = Integer.parseInt(st.nextToken());
				map[i][j] = place;
				if(place == 2) {
					q.add(new Node(j, i, 0));
				}
				else if(place == 1)
					maxVisit++;
				else
					visited[i][j] = true;
			}
		}
		Node node;
		int count = 0;
		int x,y;
		while(!q.isEmpty()) {
			node = q.poll();
			x = node.getX(); y = node.getY();
			if(visited[y][x])
				continue;
			
			if(x-1 >= 0 && map[y][x-1] == 1) {
				q.add(new Node(x-1,y,node.getDepth()+1));
			}
			if(x+1 < m && map[y][x+1] == 1) {
				q.add(new Node(x+1,y,node.getDepth()+1));
			}
			if(y-1 >= 0 && map[y-1][x] == 1) {
				q.add(new Node(x,y-1,node.getDepth()+1));
			}
			if(y+1 < n && map[y+1][x] == 1) {
				q.add(new Node(x,y+1,node.getDepth()+1));
			}

			map[y][x] = node.getDepth();

			visited[y][x] = true;
			count++;
			if(count > maxVisit)
				break;
		}
		int tmp;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(visited[i][j])
					bw.write(map[i][j] + " ");
				else
					bw.write(-1 + " ");
			}
			bw.newLine();
		}
		bw.flush();
	}
}

class Node{
	int x, y;
	int depth;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDepth() {
		return depth;
	}
	public Node(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
	
}
