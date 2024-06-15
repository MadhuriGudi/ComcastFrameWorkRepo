package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility { 
	public int getRandomNumber() {
		Random random=new Random();
		int randomnumber = random.nextInt(5000);
		return randomnumber;
	}
	public String getSystemDate(){
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateobj);
		
		return date;
	}
	public String getRequriedDateYYYYDDMM(int days) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DAY_OF_MONTH,days);
		 String ReqDate=sdf.format(cal.getTime());
		 return ReqDate;
		
				
	}

}
