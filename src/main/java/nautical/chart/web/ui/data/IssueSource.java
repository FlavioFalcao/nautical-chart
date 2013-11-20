package nautical.chart.web.ui.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 需求数据源
 * 
 * @author Cheng Feng 2013-11-19 20:20:20
 */
public class IssueSource {
	public List<File> listIssues(String projectName, String versionName) {
		List<File> versions = versionSource.listVersions(projectName);

		File version = null;
		for (File tmpVersion : versions) {
			if (tmpVersion.getName().equalsIgnoreCase(versionName)) {
				version = tmpVersion;
			}
		}

		if (version == null) {
			return new ArrayList<File>();
		} else {
			List<File> result = new ArrayList<File>();

			File tmps[] = version.listFiles();
			for (File tmp : tmps) {
				if (tmp.isFile()) {
					result.add(tmp);
				}
			}

			return result;
		}
	}

	// setter
	public void setVersionSource(VersionSource versionSource) {
		this.versionSource = versionSource;
	}

	// attributes
	private VersionSource versionSource;
}
