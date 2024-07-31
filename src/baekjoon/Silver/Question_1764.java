package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		Map<String, Boolean> nameList = new HashMap<String, Boolean>();
		for(int i=0;i<n;i++){
			nameList.put(br.readLine(), true);
		}
		int count = 0;
		List<String> dbjList = new LinkedList<>();
		String name;
		for(int i=0;i<m;i++){
			name = br.readLine();
			if(nameList.put(name, true)!= null) {
				count++;
				dbjList.add(name);
			}
		}
		Collections.sort(dbjList);
		bw.write(count+"\n");
		for(int i=0;i<dbjList.size();i++){
			bw.write(dbjList.get(i) + "\n");
		}
		bw.flush();
	}
}
