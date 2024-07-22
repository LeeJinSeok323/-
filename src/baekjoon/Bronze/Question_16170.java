package baekjoon.Bronze;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.StringTokenizer;

public class Question_16170 {
	public static void main(String[] args) throws IOException {
		ZoneOffset zoneOffset = ZoneOffset.of("-00:00");
		ZonedDateTime zonedDateTimeWithOffset = ZonedDateTime.now(zoneOffset);
		
		String s = zonedDateTimeWithOffset.toString();
		System.out.println(s.substring(0,4));
		System.out.println(s.substring(5,7));
		System.out.println(s.substring(8,10));
		
	}
}
