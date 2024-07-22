package baekjoon.Silver;
/*
import java.util.*;
import java.io.*;
public class BFS_practice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int goal = Integer.parseInt(br.readLine());
		int memo[] = new int[5001];
		Queue<State> q = new LinkedList<>();
		if (goal != 4 || goal != 7){
			q.add(new State(0, 0));
		}
		else {
			System.out.println(-1);
		}
		while(!q.isEmpty()){
			State current = q.poll();
			if(current.value == goal) {
				System.out.println(current.depth);
				break;
			}
			else if(current.value > goal) {
				continue;
			}
			else if(memo[current.value] != 0) {
				continue;
			}
			else {
				q.add(new State(current.value+5, current.depth+1));
				q.add(new State(current.value+3, current.depth+1));
			}
		}
	}
}
class State{
	public int value;
	public int depth;
	public State(int value, int depth) {
		this.value = value;
		this.depth = depth;
	}
	public void addValue(int value) {
		
	}
}

*/