package baekjoon.Platinum;
import java.util.*;
import java.io.*;
public class Question_4149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n = Long.parseLong(br.readLine());
		ArrayList<Long> a = new ArrayList<Long>();
		if(n%2 == 0) {
			n = n >> 1;
			a.add((long) 2);
		}
		else {
			long d = 3;
			while(n != 1) {
				if(n % d == 0) {
					a.add(d);
					n = n/d;
					continue;
				}
				d +=2;
			}
		}
		for(Long i : a) {
			bw.write(i+"\n");
		}
		bw.flush();
	}
}
