package nautical.chart.web.ui.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目数据源
 * 
 * @author Cheng Feng 2013-11-18 22:30
 */
public class ProjectSource {
	// init method
	public void init() {
		File tmp = new File(location);
		if (tmp.exists() && tmp.isDirectory()) {
			dataDir = tmp;
		} else {
			dataDir = null;
		}
	}

	public List<File> listProjects() {
		if (dataDir == null) {
			return new ArrayList<File>();
		} else {
			List<File> result = new ArrayList<File>();

			File tmps[] = dataDir.listFiles();
			for (File tmp : tmps) {
				if (tmp.isDirectory()) {
					result.add(tmp);
				}
			}

			return result;
		}
	}

	// getter & setter
	public void setLocation(String location) {
		this.location = location;
	}

	public File getDataDir() {
		return dataDir;
	}

	// attributes
	private String location;
	private File dataDir;
}
