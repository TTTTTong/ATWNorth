package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class DateUtil {

	public  String getTime(){
		//大写H为24小时制，小写为12小时制
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		return sdf.format(new Date());
	}
	public String getLogTime(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return sdf.format(new Date());
	}
	public String getRegTime(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(new Date());
	}
	public static void main(String[] args) {
	
	}

}
