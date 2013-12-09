package nautical.chart.web.app1.module.action;

import org.springframework.beans.factory.annotation.Autowired;

import nautical.chart.web.ui.data.IssueSource;
import nautical.chart.web.ui.data.Status;
import nautical.chart.web.ui.model.Issue;
import nautical.chart.web.ui.model.Type;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * 增加需求对应的action
 * 
 * @author Cheng Feng 2013-12-06 23:16:45
 */
public class IssueAction {
	@Autowired
	private IssueSource issueSource;

	public void doAdd(@Param("project") String project, @Param("version") String version, @FormGroup("issue") Issue issue, Navigator nav) {
		issue.setType(Type.REQUIREMENT);
		Status status = Status.TODO;
		status.setTime(System.currentTimeMillis());
		issue.addStatus(status);
		issue.setProject(project);
		issue.setVersion(version);
		boolean result = issueSource.addIssue(issue);
		nav.redirectTo("app1Link").withTarget("version").withParameter("project", project).withParameter("version", version);
	}

	public void doDel(@Param("project") String project, @Param("version") String version, @Param("issue") String issue, Navigator nav) {
		Issue oldIssue = new Issue();
		oldIssue.setName(issue);
		oldIssue.setProject(project);
		oldIssue.setVersion(version);
		boolean result = issueSource.delIssue(oldIssue);
		nav.redirectTo("app1Link").withTarget("version").withParameter("project", project).withParameter("version", version);
	}
}
