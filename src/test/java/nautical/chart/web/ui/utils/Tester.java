package nautical.chart.web.ui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Tester {

	public static void main(String args[]) {
		Set<Integer> ints = new HashSet<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(1);
		System.out.println(ints.size());
		for (Integer i : ints) {
		    System.out.println(i);
		}
	}
}
