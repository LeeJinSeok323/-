package baekjoon.Silver;
import java.util.*;
import java.io.*;
public class Question_10816 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int key;
		for(int i=0;i<n;i++){
			key = Integer.parseInt(st.nextToken());
			hash.put(key, hash.getOrDefault(key, 0)+1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int value = 0;
		for(int i=0;i<m;i++){
			key = Integer.parseInt(st.nextToken());
			value = hash.get(key) == null ? 0 : hash.get(key);
			bw.write(value+" ");
		}
		bw.flush();
		
	}
//	
//	public static int customBinarySearch(int pivot, int number) {
//		if(numbers[pivot] > number) {
//			customBinarySearch((n+pivot)/2, number);
//		}
//		else if(numbers[pivot] < number) {
//			customBinarySearch(pivot/2, number);
//		}
//		else if(numbers[pivot] == number) {
//			boolean isStartPivot = false;
//			boolean isEndPivot = false;
//			int tmpIdx = 1;
//			while(!isStartPivot) {
//				if(numbers[pivot-tmpIdx] == number) {
//					tmpIdx--;
//				}
//				else {
//					tmpIdx++;
//					isStartPivot = true;
//				}
//			}
//			tmpIdx = 1;
//			int count = 0;
//			while(!isEndPivot) {
//				count++;
//				if(numbers[pivot+tmpIdx] == number) {
//					tmpIdx++;
//				}
//				else {
//					isEndPivot = true;
//				}
//			}
//			
//			return count;
//		}
//
//		return 0;
//	}
}
