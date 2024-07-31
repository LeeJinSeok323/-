package baekjoon.Silver;
import java.util.*;
import java.io.*;
public class Question_2697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer[]> hash = new HashMap<String, Integer[]>();
		
		hash.put("abc", new Integer[]{10,0});
		
		System.out.println(hash.get("abc")[0]);
	}
}
