package baekjoon.Silver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
public class Question_10845 {
	static Queue<Integer> q = new LinkedList<Integer>();
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ans = new int[n];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<n;i++){
			int tmp = requestQueue(br.readLine());
			if(tmp != -9 )
				bw.write(Integer.toString(tmp)+"\n");
		}
		
		bw.flush();
	}
	public static int requestQueue(String request) {
		// u:push o:pop r:front a:back i:size m:empty
		char req = request.charAt(1);
		switch(req) {
		case 'u':
			q.add(Integer.parseInt(request.substring(5)));
			break;
		case 'o':
			if(!q.isEmpty())
				return q.poll();
			else
				return -1;
		case 'r':
			if(!q.isEmpty())
				return q.peek();
			else
				return -1;
		case 'a':
			if(!q.isEmpty()) 
				return ((LinkedList<Integer>)q).getLast();
			else
				return -1;
		case 'i':
			return q.size();
		case 'm':
			if(!q.isEmpty())
				return 0;
			else
				return 1;
		}
		return -9;
	}
	
}
