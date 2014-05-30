package nautical.chart.web.ui.datasource;

import java.util.Date;

import nautical.chart.web.ui.model.State;

public class Test {

	public static void main(String args[]) throws InterruptedException {
		State s1 = State.DOING;
//		s1.setTime(System.currentTimeMillis());
		
		Thread.sleep(1000);
		
		State s2 = State.DONE;
//		s2.setTime(System.currentTimeMillis());

//		System.out.println(s1 + " - " + new Date(s1.getTime()));
//		System.out.println(s2 + " - " + new Date(s2.getTime()));
	}
}
