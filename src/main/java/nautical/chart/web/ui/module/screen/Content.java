package nautical.chart.web.ui.module.screen;

import javax.servlet.http.HttpServletRequest;

import nautical.chart.web.ui.datasource.ContentSource;
import nautical.chart.web.ui.model.Issue;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;

/**
 * 需求内容展示视图
 * 
 * @author Cheng Feng
 */
public class Content {
	@Autowired
    private HttpServletRequest request;
	@Autowired
	private ContentSource contentSource;

	public void execute(Context context) {
		String projectName = request.getParameter("project");
		context.put("project", projectName);

		String versionName = request.getParameter("version");
		context.put("version", versionName);

		String issueName = request.getParameter("issue");
		context.put("issue", issueName);

		Issue issue = contentSource.getContent(projectName, versionName, issueName);
		context.put("content", issue);
	}
}
