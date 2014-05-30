package nautical.chart.web.ui.datasource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import nautical.chart.web.ui.model.Issue;
import nautical.chart.web.ui.model.State;
import nautical.chart.web.ui.model.Type;

/**
 * 需求内容数据源
 * 
 * @author Cheng Feng 2013-11-20 15:04:30
 */
public class ContentSource {
	public Issue getContent(String projectName, String versionName, String issueName) {
		List<File> issues = issueSource.listIssues(projectName, versionName);

		File issueFile = null;
		for (File tmpIssue : issues) {
			if (tmpIssue.getName().equalsIgnoreCase(issueName)) {
				issueFile = tmpIssue;
				break;
			}
		}

		if (issueFile == null) {
			return null;
		} else {
			BufferedReader reader = null;

			try {
			    Issue result = new Issue();
			    result.setName(issueName);

				reader = new BufferedReader(new FileReader(issueFile));
				String description = reader.readLine();
				result.setDescription(description);
				String tmpType = reader.readLine();
				Type type = Type.valueOf(tmpType);
				result.setType(type);
				String originator = reader.readLine();
				result.setOriginator(originator);
				String owner = reader.readLine();
				result.setOwner(owner);
				String statusContent = reader.readLine();
				List<State> status = Issue.string2Status(statusContent);
				result.setStatus(status);

				return result;
			} catch (FileNotFoundException e) {
				return null;
			} catch (IOException e) {
				return null;
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO
					}
				}
			}
		}
	}

	public boolean updateContent(Issue oldIssue, Issue newIssue) {
		List<File> issues = issueSource.listIssues(oldIssue.getProject(), oldIssue.getVersion());

		File issueFile = null;
		for (File tmpIssue : issues) {
			if (tmpIssue.getName().equalsIgnoreCase(oldIssue.getName())) {
				issueFile = tmpIssue;
				break;
			}
		}

		if (issueFile == null) {
			return false;
		} else {
			boolean result = true;
			BufferedWriter writer = null;

			try {
				writer = new BufferedWriter(new FileWriter(issueFile));
				writer.write(newIssue.getDescription() + "\n");
				writer.write(newIssue.getType().name() + "\n");
				writer.write(newIssue.getOriginator() + "\n");
				writer.write(newIssue.getOwner() + "\n");
				String status = Issue.status2String(newIssue.getStatus());
				writer.write(status + "\n");
			} catch (Exception e) {
				return false;
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						// TODO
					}
				}
			}

			if (!oldIssue.getName().equals(newIssue.getName())) {
				File distFile = new File(issueFile.getParent() + File.separator + newIssue.getName());
			    result = issueFile.renameTo(distFile);
			}

			return result;
		}
	}

	// setter
	public void setIssueSource(IssueSource issueSource) {
		this.issueSource = issueSource;
	}

	// attributes
	private IssueSource issueSource;
}
