package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Question_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for(int i=0;i<n;i++){
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
                if(a.equals(b)) {
                    return 0;  // 같은 단어면 0 반환
                }
                if(a.length() != b.length()) {
                    return a.length() - b.length();  // 길이가 다르면 길이 차이 반환
                }
                // 길이가 같으면 사전순 비교
                return a.compareTo(b);
            }
		});
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String tmpWord = "";
		for(String word : words) {
			if(word.equals(tmpWord))
				continue;
			bw.write(word);
			bw.newLine();
			tmpWord = word;
		}
		bw.flush();
	}
}
