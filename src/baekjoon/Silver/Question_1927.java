package baekjoon.Silver;

import java.io.*;
public class Question_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		MinimalHeap heap = new MinimalHeap(n);
		
		for(int i=1;i<n+1;i++){
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				bw.write(heap.pop()+"\n");
			}
			else {
				heap.add(num);
			}
		}// for문 종료
		bw.flush();
		
	}
	
}

class MinimalHeap{
	int[] heap;
	int lastIdx;
	public MinimalHeap(int n) {
		this.heap = new int[n+1];
		lastIdx = 0;
	}
	
	public int pop() {
		if(lastIdx == 0)
			return 0;
		int min = heap[1];
		heap[1] = heap[lastIdx];
		heap[lastIdx] = 0;
		lastIdx--;
		downHeap();
		return min;
	}
	public void add(int num) {
		lastIdx++;
		heap[lastIdx] = num;
		upHeap();
		return; 
	}
	public void upHeap() {
		int idx = lastIdx;
		while(idx > 1 && heap[idx/2] > heap[idx]) {
			int parentsIdx = idx / 2;
			swap(parentsIdx, idx);
			idx = parentsIdx;
		}
		
	}

	public void downHeap() {
		int idx = 1;
		while(idx*2 <= lastIdx) {
			int leftChild = idx*2;
			int rightChild = idx*2+1;
			int smallerChild = leftChild;
			
			if(rightChild <= lastIdx && heap[leftChild] > heap[rightChild])
				smallerChild = rightChild;
			
			if(heap[idx] < heap[smallerChild])
				break;
			swap(idx, smallerChild);
			idx = smallerChild;
		}
	}
	
	public void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
}
