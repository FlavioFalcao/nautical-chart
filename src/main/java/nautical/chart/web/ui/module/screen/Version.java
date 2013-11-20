package nautical.chart.web.ui.module.screen;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nautical.chart.web.ui.data.IssueSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;

/**
 * 版本展示视图
 * 
 * @author Cheng Feng 2013-11-19 22:22:22
 */
public class Version {
	@Autowired
    private HttpServletRequest request;
	@Autowired
	private IssueSource issueSource;

	public void execute(Context context) {
		String projectName = request.getParameter("project");
		context.put("project", projectName);

		String versionName = request.getParameter("version");
		context.put("version", versionName);

		List<File> issues = issueSource.listIssues(projectName, versionName);
		context.put("issues", issues);
	}
}
