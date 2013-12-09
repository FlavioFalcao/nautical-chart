package nautical.chart.web.ui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tester {

	public static void main(String args[]) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		System.out.println(sdf.format(date));
	}
}
