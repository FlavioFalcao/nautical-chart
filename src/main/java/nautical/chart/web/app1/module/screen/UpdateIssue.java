package nautical.chart.web.app1.module.screen;

import nautical.chart.web.ui.datasource.ContentSource;
import nautical.chart.web.ui.model.Issue;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * @author Cheng Feng 2013-12-09 17:39:30
 */
public class UpdateIssue {
	@Autowired
	private ContentSource contentSource;

    public void execute(@Param("project") String project, @Param("version") String version, @Param("issue") String issueName, Context context) throws Exception {
    	context.put("project", project);
    	context.put("version", version);
		context.put("issue", issueName);

		Issue issue = contentSource.getContent(project, version, issueName);
		context.put("content", issue);
		context.put("lastStatus", issue.getStatus().get(issue.getStatus().size() - 1).name());
    }
}
