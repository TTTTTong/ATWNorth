package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		return sdf.format(new Date());
	}
	public static void main(String[] args) {
		System.out.println(getTime());
	}

}
