package nautical.chart.web.ui.data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * 版本数据源
 * 
 * @author Cheng Feng 2013-11-19 15:36:30
 */
public class VersionSource {
	// init method
	public void init() {
		dataDir = projectSource.getDataDir();
	}

	public List<String> listVersions(final String projectName) {
		if (dataDir == null) {
			return new ArrayList<String>();
		} else {
			File tmps[] = dataDir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return name.equalsIgnoreCase(projectName) ? true : false;
				}
			});

			File project = tmps[0];
			if (project.isDirectory()) {
				List<String> result = new ArrayList<String>();

				tmps = project.listFiles();
				for (File tmp : tmps) {
					if (tmp.isDirectory()) {
					    result.add(tmp.getName());
					}
				}

				return result;
			} else {
				return new ArrayList<String>();
			}
		}
	}

	// setter
	public void setProjectSource(ProjectSource projectSource) {
		this.projectSource = projectSource;
	}

	// attributes
	private ProjectSource projectSource;
	private File dataDir;
}
