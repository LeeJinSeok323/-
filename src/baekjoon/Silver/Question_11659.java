package baekjoon.Silver;

import java.io.*;
import java.util.*;
public class Question_11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int idx = str.indexOf(" ");
        int n = Integer.parseInt(str.substring(0, idx));
        int m = Integer.parseInt(str.substring(idx+1));
        
        int[] sums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        sums[0] = num;
        for(int i=1; i<n; i++){
        	num = Integer.parseInt(st.nextToken());
            sums[i] = sums[i-1] + num;
        }
        
        for(int t=0; t<m; t++){
        	 str = br.readLine();
             idx = str.indexOf(" ");
             int i = Integer.parseInt(str.substring(0, idx));
             int j = Integer.parseInt(str.substring(idx+1));
             if(i == 1)
            	 bw.write(sums[j-1] + "\n");
             else
            	 bw.write(sums[j-1] - sums[i-2] + "\n");
        }
        bw.flush();
    }
 
}