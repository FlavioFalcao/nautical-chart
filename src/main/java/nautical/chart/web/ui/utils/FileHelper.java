package nautical.chart.web.ui.utils;

import java.io.File;

/**
 * @author Cheng Feng 2013-12-09 16:32:30
 */
public class FileHelper {

	public static boolean delFile(File file) {
		if (file.isDirectory()) {
			boolean result = true;

			File[] children = file.listFiles();
			for (File child : children) {
				result = delFile(child);

				if (!result) {
					break;
				}
			}

			result = file.delete();

			return result;
		} else {
			return file.delete();
		}
	}
}
