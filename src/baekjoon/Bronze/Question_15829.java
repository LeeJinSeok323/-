package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Question_15829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[] c = br.readLine().toCharArray();
		int total = 0;
		if (n <= 5) {
			for(int i=0; i<n; i++) {
				int ch = c[i];
				ch = ch - 96;
				total += ch * Math.pow(31, i);
			}
			System.out.println(total);
		}
		else {
			BigInteger big = new BigInteger("0");
			BigInteger hash = new BigInteger("31");
			for(int i=0; i<n; i++) {
				int ch = c[i]-96;
				BigInteger chh = BigInteger.valueOf(ch);
				big = big.add(BigInteger.valueOf(31).pow(i).multiply(chh));
			}
			
			System.out.println(big.mod(BigInteger.valueOf(1234567891)));
		}
		
	}
}
