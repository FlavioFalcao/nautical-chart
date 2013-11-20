package nautical.chart.web.ui.data;

import java.util.Date;

public class Test {

	public static void main(String args[]) throws InterruptedException {
		Status s1 = Status.DOING;
		s1.setTime(System.currentTimeMillis());
		
		Thread.sleep(1000);
		
		Status s2 = Status.DONE;
		s2.setTime(System.currentTimeMillis());

		System.out.println(s1 + " - " + new Date(s1.getTime()));
		System.out.println(s2 + " - " + new Date(s2.getTime()));
	}
}
