package utils;

import java.util.Date;

public class CommanUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_BASICTIME=30;
	
	public static String getEmailWithTimeStamp() {
		Date date = new Date();

		return "madhav" + date.toString().replace(" ", "_").replace(":", "") + "@gmail.com";

	}

}
