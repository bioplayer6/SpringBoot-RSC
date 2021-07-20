package project.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {

	public static Date date(Date current,Integer id) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(current);
		calendar.add(calendar.DATE, id);
		current = calendar.getTime();
		return current;
	}
}
