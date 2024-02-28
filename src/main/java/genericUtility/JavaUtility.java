package genericUtility;

import java.util.Date;

public class JavaUtility {
	public String getsystemDate() {
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"-"+dArr[3].replace(":", "_");
		return currentDate;
		
	}

}
