package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_1012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int times = Integer.parseInt(br.readLine());

		for(int num=0;num<times;num++){
			String[] s = br.readLine().split(" ");
			int m = Integer.parseInt(s[0]);
			int n = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);
			int[][] map = new int[n][m];
			for(int i=0;i<k;i++){
				String str = br.readLine();
				int spaceIdx = str.indexOf(" ");
				int x = Integer.parseInt(str.substring(0, spaceIdx));
				int y = Integer.parseInt(str.substring(spaceIdx+1));
				map[y][x] = 1; 
			}
			bw.write(placeWorm(map) +"\n");
		}
		
		bw.flush();
	}
	public static int placeWorm(int[][] map) {
		Stack<Area> s = new Stack<Area>();
		int count = 0;
		boolean isCleared = false;
		while(true) {
			s = checkArea(map);
			if(s.isEmpty())
				break;
			while(!s.isEmpty()) {
				Area a = s.pop();
				int x = a.getX();
				int y = a.getY();
				if(x > 0 && map[y][x-1] == 1) {
					s.add(new Area(x-1, y));
				}
					
				if(x < map[0].length-1 && map[y][x+1] == 1) {
					s.add(new Area(x+1, y));
				}
				if(y > 0 && map[y-1][x] == 1) {
					s.add(new Area(x, y-1));
				}
				if(y < map.length-1 && map[y+1][x] == 1) {
					s.add(new Area(x, y+1));	
				}
				map[y][x] = 0;
			} // while 스택이 비어 종료
			count++;
		}// while 탐색 종료
		return count;
	}
	public static Stack<Area> checkArea(int[][] map) {
		Stack<Area> s = new Stack<Area>();
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				if(map[i][j] == 1) {
					s.add(new Area(j, i));
					return s;
				}
			}
		}
		return s;
	}
}

class Area{
	int x, y;
	
	public Area(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}