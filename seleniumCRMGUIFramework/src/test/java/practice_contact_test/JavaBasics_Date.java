package practice_contact_test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics_Date {

	public static void main(String[] args) {
		Date dateobj=new Date();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd");
		String actdate = simp.format(dateobj);
		System.out.println(actdate);
		Calendar cal=simp.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,-30);
		String reqdate = simp.format(cal.getTime());
		System.out.println(reqdate);
		

	}

}
