package nautical.chart.web.ui.utils;

import java.io.File;

public class Tester {

	public static void main(String args[]) {
		File f1 = new File("/home/zack/data");
		System.out.println(f1.getAbsolutePath());
		File f2 = new File("/home/zack/data/");
		System.out.println(f2.getAbsolutePath());
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
	}
}
