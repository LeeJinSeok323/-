package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_11724 {
	static ArrayList<Node> arr;
	static BufferedReader br;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int nms[] = read();
		int tmp[]= new int[2];
		arr = new ArrayList<Node>();
		// 노드 생성
		for(int i=1;i<=nms[0];i++){
			arr.add(new Node(i, nms[0]));
		}
		// 링크 입력
		for(int i=0;i<nms[1];i++){
			tmp = read();
			arr.get(tmp[0]-1).addLink(tmp[1]);
			arr.get(tmp[1]-1).addLink(tmp[0]);
		}
		int count = 0;
		// 전체 노트 탐색 
		for(Node n : arr) {
			if(n.isVisited)
				continue;
			else {
				visitNodes(n);
				count++;
			}
		}
		
		
		System.out.println(count);
	}
	public static void visitNodes(Node n) {
		if(n.isVisited)
			return;
		n.isVisited = true;
		int[] links = n.getLink();
		for(int link : links) {
			if(link == 0)
				continue;
			visitNodes(arr.get(link-1));
		}
	}
	
	public static int[] read() throws IOException {
		String s = br.readLine();
		
		int space = s.indexOf(' ');
		int a[] = {Integer.parseInt(s.substring(0,space)), Integer.parseInt(s.substring(space+1))};
		return a;
	}
	
	
	// 패키지 충돌방지를 위한 Inner class 선언
	static class Node{
		int id;
		int[] link;
		int idx = 0;
		boolean isVisited;
	
		public Node(int id, int maxId) {
			this.id = id;
			this.link = new int[maxId];
			this.isVisited = false;
		}
		public int getId() {
			return id;
		}
		public int[] getLink() {
			return link;
		}
	
		public boolean isVisited() {
			return isVisited;
		}
		public void addLink(int num) {
			link[idx] = num;
			idx++;
		}
	}

}
