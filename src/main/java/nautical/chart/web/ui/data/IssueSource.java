package nautical.chart.web.ui.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nautical.chart.web.ui.model.Issue;
import nautical.chart.web.ui.model.Version;

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

	/**
	 * 生成需求数据文件
	 */
	public boolean addIssue(Issue newIssue) {
		File issue = new File(versionSource.getDataDir().getAbsolutePath() + File.separator + newIssue.getProject() + File.separator + newIssue.getVersion() + File.separator + newIssue.getName());

		if (issue.exists() && issue.isFile()) {
			return true;
		} else if (!issue.exists()) {
			FileWriter writer = null;

			try {
				boolean result = issue.createNewFile();

				writer = new FileWriter(issue);
				writer.write(newIssue.getDescription() + "\n");
				writer.write(newIssue.getType().name() + "\n");
				writer.write(newIssue.getOriginator() + "\n");
				writer.write(newIssue.getOwner() + "\n");
				Status s = Status.TODO;
				s.setTime(System.currentTimeMillis());
				List<Status> status = new ArrayList<Status>();
				status.add(s);
				writer.write(Issue.status2String(status));

				return result;
			} catch (IOException e) {
				return false;
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			return false;
		}
	}

	public boolean delIssue(Issue oldIssu) {
		File issue = new File(versionSource.getDataDir().getAbsolutePath() + File.separator + oldIssu.getProject() + File.separator + oldIssu.getVersion() + File.separator + oldIssu.getName());

		if (issue.exists()) {
			return issue.delete();
		} else {
			return false;
		}
	}

	/**
	 * 更新指定版本
	 */
	public boolean updateVersion(Version oldVersion, Version newVersion) {
		File oldVersionF = versionSource.getVersion(oldVersion.getProject(), oldVersion.getName());
		File newVersionF = new File(oldVersionF.getParent() + File.separator + newVersion.getName());
		boolean result = oldVersionF.renameTo(newVersionF);

		return result;
	}

	// setter
	public void setVersionSource(VersionSource versionSource) {
		this.versionSource = versionSource;
	}

	// attributes
	private VersionSource versionSource;
}
