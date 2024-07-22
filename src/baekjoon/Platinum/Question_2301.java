package baekjoon.Platinum;

import java.io.*;
import java.util.Stack;
import java.util.ArrayList;
import java.lang.Math;
public class Question_2301 {
	// 마법구슬 플래티넘 1 
	// 예외경우 중앙 2칸과 외부 2칸
	// 이외에는 갈 수 있는 칸중 가장 먼 수를 체크해가면서 지워나가기. 구현해보기!!!!
	private static ArrayList<Integer> visitLog = new ArrayList<>();
	private static int roomSize; 
	private static int connectBallDirection = 0;
	private static Stack<Integer> connectBall = new Stack<>();
	private static int maxDepth = 0;
	public static void main(String[] args) {
		Question_2301 q = new Question_2301();
		q.setUpInit();
		q.inOutProcessorIterative(0, (roomSize/2)-1);
		
		StringBuilder sb = new StringBuilder();
		for(int v : visitLog) {
			sb.append(v+1+" ");
		}
		System.out.println(sb.toString());
	}
	public void inOutProcessorIterative(int start, int halfLeft) {
	    Stack<int[]> stack = new Stack<>();
	    stack.push(new int[]{start, halfLeft});

	    while (!stack.isEmpty()) {
	        int[] current = stack.pop();
	        start = current[0];
	        halfLeft = current[1];

	        int[] pointsIndex = {start, halfLeft, roomSize - halfLeft -1, roomSize - start -1};
		    int cur = visitLog.get(visitLog.size()-1);
		    int quaterLeft = pointsIndex[0] + (pointsIndex[1] - pointsIndex[0] + 1) / 2 - 1 ;
		    int quaterRight = getMirroredIndex(quaterLeft);
		    
		    if(pointsIndex[1] - pointsIndex[0] == 1) {
		    	if(cur == pointsIndex[0] ) {
		            visitLog.add(pointsIndex[3]);
		            visitLog.add(pointsIndex[1]);
		            visitLog.add(pointsIndex[2]);
		            if(!connectBall.empty()) {
		    			visitLog.add(pointsIndex[2]+ connectBall.pop()*connectBallDirection);
		    		}
		        }
		        else if (cur == pointsIndex[1]) {
		        	visitLog.add(pointsIndex[2]);
		            visitLog.add(pointsIndex[0]);
		            visitLog.add(pointsIndex[3]);
		            if(!connectBall.empty()) {
		    			visitLog.add(pointsIndex[3]+ connectBall.pop()*connectBallDirection);
		    		}
		        }
		        else if (cur == pointsIndex[2]) {
		        	visitLog.add(pointsIndex[1]);
		            visitLog.add(pointsIndex[3]);
		            visitLog.add(pointsIndex[0]);
		            if(!connectBall.empty()) {
		    			visitLog.add(pointsIndex[0]+ connectBall.pop()*connectBallDirection);
		    		}
		        }
		        else {
		        	visitLog.add(pointsIndex[0]);
		            visitLog.add(pointsIndex[2]);
		            visitLog.add(pointsIndex[1]);
		            if(!connectBall.empty()) {
		    			visitLog.add(pointsIndex[1]+ connectBall.pop()*connectBallDirection);
		    		}
		        }
		    }
		    else {
		        connectBall.push(pointsIndex[3] - pointsIndex[1]);
		        if(cur > quaterLeft && cur < quaterRight ) {
		        	stack.push(new int[]{pointsIndex[0], quaterLeft});
		        	stack.push(new int[]{quaterLeft+1, pointsIndex[1]});
		        }
		        else if (cur <= quaterLeft || cur >= quaterRight) {
		        	stack.push(new int[]{quaterLeft+1, pointsIndex[1]});
		        	stack.push(new int[]{pointsIndex[0], quaterLeft});
		        }
		    }
	        // 재귀 호출 대신 stack.push()를 사용
	    }
	}
	public void inOutProcessor(int start, int halfLeft) {

	    int[] pointsIndex = {start, halfLeft, roomSize - halfLeft -1, roomSize - start -1};
	    int cur = visitLog.get(visitLog.size()-1);
	    int quaterLeft = pointsIndex[0] + (pointsIndex[1] - pointsIndex[0] + 1) / 2 - 1 ;
	    int quaterRight = getMirroredIndex(quaterLeft);
	    
	    
	    if(pointsIndex[1] - pointsIndex[0] == 1) {
	    	if(cur == pointsIndex[0] ) {
	            visitLog.add(pointsIndex[3]);
	            visitLog.add(pointsIndex[1]);
	            visitLog.add(pointsIndex[2]);
	            if(!connectBall.empty()) {
	    			visitLog.add(pointsIndex[2]+ connectBall.pop()*connectBallDirection);
	    		}
	        }
	        else if (cur == pointsIndex[1]) {
	        	visitLog.add(pointsIndex[2]);
	            visitLog.add(pointsIndex[0]);
	            visitLog.add(pointsIndex[3]);
	            if(!connectBall.empty()) {
	    			visitLog.add(pointsIndex[3]+ connectBall.pop()*connectBallDirection);
	    		}
	        }
	        else if (cur == pointsIndex[2]) {
	        	visitLog.add(pointsIndex[1]);
	            visitLog.add(pointsIndex[3]);
	            visitLog.add(pointsIndex[0]);
	            if(!connectBall.empty()) {
	    			visitLog.add(pointsIndex[0]+ connectBall.pop()*connectBallDirection);
	    		}
	        }
	        else {
	        	visitLog.add(pointsIndex[0]);
	            visitLog.add(pointsIndex[2]);
	            visitLog.add(pointsIndex[1]);
	            if(!connectBall.empty()) {
	    			visitLog.add(pointsIndex[1]+ connectBall.pop()*connectBallDirection);
	    		}
	        }
	    }
	    else {
	        connectBall.push(pointsIndex[3] - pointsIndex[1]);
	        if(cur > quaterLeft && cur < quaterRight ) {
	            inOutProcessor(quaterLeft + 1, pointsIndex[1]);
	            inOutProcessor(pointsIndex[0], quaterLeft);
	        }
	        else if (cur <= quaterLeft || cur >= quaterRight) {
	            inOutProcessor(pointsIndex[0], quaterLeft);
	            inOutProcessor(quaterLeft+ 1, pointsIndex[1]);
	        }
	    }

	}
	
	public int getMirroredIndex(int index) {
		return roomSize - index - 1;
	}
	
	public void setUpInit() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int startPosition = 0;
		//입력 받기
		try {
			roomSize = Integer.parseInt(br.readLine());
			startPosition = Integer.parseInt(br.readLine());
		}catch(IOException e){
            e.printStackTrace();
		}
		connectBallDirection = startPosition <= roomSize/ 2  ? -1 : +1;
		// 초기화
		visitLog.add(startPosition - 1);
	}
	
}
	