package nautical.chart.web.ui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 各种数据转换器
 * 
 * @author Cheng Feng 2013-11-20 16:03:30
 */
public class Transformer {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public static long stringDate2Long(String stringDate) {
		try {
			return sdf.parse(stringDate).getTime();
		} catch (ParseException e) {
			return System.currentTimeMillis();
		}
	}
}
