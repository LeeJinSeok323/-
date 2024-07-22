package baekjoon.Silver;

import java.util.*;
import java.io.*;
public class Question_10814 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String tmp;
		int spaceIndex;
		String[][] pl = new String[n][2]; 
		for(int i=0;i<n;i++){
			tmp = br.readLine();
			spaceIndex = tmp.indexOf(' ');
			pl[i][0] = tmp.substring(0, spaceIndex);
			pl[i][1] = tmp.substring(spaceIndex+1);
		}
		Arrays.sort(pl,new Comparator<String[]>(){
			@Override
			public int compare(String[] a, String[] b) {
				return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
				
			}
		});
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<n;i++){
			bw.write(pl[i][0]+" "+pl[i][1]);
			bw.newLine();
		}
		bw.flush();
	}
}
