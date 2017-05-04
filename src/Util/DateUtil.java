package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getTime(){
		//大写H为24小时制，小写为12小时制
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		return sdf.format(new Date());
	}
	public static void main(String[] args) {
		System.out.println(getTime());
	}

}
