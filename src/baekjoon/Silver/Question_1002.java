package baekjoon.Silver;

// 실버 3
import java.util.Scanner;
import java.util.ArrayList;
public class Question_1002 {
	public static void main(String[] args) {
		ArrayList<Float> xList = new ArrayList<>();
		ArrayList<Float> yList = new ArrayList<>();
		ArrayList<Float> rList = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			xList.add(sc.nextFloat());
			yList.add(sc.nextFloat());
			rList.add(sc.nextFloat());
			xList.add(sc.nextFloat());
			yList.add(sc.nextFloat());
			rList.add(sc.nextFloat());
			
			sc.nextLine();
		}
		
		for(int i=0; i<(2*n); i+=2) {
			float x1 = xList.get(i);
			float x2 = xList.get(i+1);
			float y1 = yList.get(i);
			float y2 = yList.get(i+1);
			float r1 = rList.get(i);
			float r2 = rList.get(i+1);
			
			float distance = squareNumber(x1-x2) + squareNumber(y1-y2);
			
			
			if(distance != 0) { 
				if (distance > squareNumber(r1+r2))
					System.out.println(0);
				else if (distance == squareNumber(r1+r2)) {
					System.out.println(1);
				}
				else {
					if(distance > squareNumber(r1-r2) ) {
						System.out.println(2);
					}
					else if(distance == squareNumber(r1-r2)) {
						System.out.println(1);
					}
					else {
						System.out.println(0);
					}
				}
				
			}
			else if (distance == 0 && r1 != r2)
				System.out.println(0);
			else
				System.out.println(-1);
			
		}

	}
	public static float squareNumber(float num) {
		return num * num;
	}
	

	
}
