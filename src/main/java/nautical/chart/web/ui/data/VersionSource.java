package nautical.chart.web.ui.data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import nautical.chart.web.ui.model.Version;

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

	public File getVersion(final String projectName, final String versionName) {
		List<File> versions = listVersions(projectName);

		for (File version : versions) {
			if (version.getName().equalsIgnoreCase(versionName)) {
				return version;
			}
		}

		return null;
	}

	public List<File> listVersions(final String projectName) {
		if (dataDir == null) {
			return new ArrayList<File>();
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
				List<File> result = new ArrayList<File>();

				tmps = project.listFiles();
				for (File tmp : tmps) {
					if (tmp.isDirectory()) {
						result.add(tmp);
					}
				}

				return result;
			} else {
				return new ArrayList<File>();
			}
		}
	}

	public boolean addVersion(Version newVersion) {
		File version = new File(dataDir.getAbsolutePath() + File.separator + newVersion.getProject() + File.separator + newVersion.getName());

		if (version.exists() && version.isDirectory()) {
			return true;
		} else if (!version.exists()) {
			return version.mkdirs();
		} else {
			return false;
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
