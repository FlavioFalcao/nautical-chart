package nautical.chart.web.app1.module.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import nautical.chart.web.ui.datasource.ContentSource;
import nautical.chart.web.ui.datasource.IssueSource;
import nautical.chart.web.ui.model.Issue;
import nautical.chart.web.ui.model.State;
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
	@Autowired
	private ContentSource contentSource;

	public void doAdd(@Param("project") String project, @Param("version") String version, @FormGroup("issue") Issue issue, Navigator nav) {
		issue.setType(Type.REQUIREMENT);
		State status = State.TODO;
//		status.setTime(System.currentTimeMillis());
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

	public void doUpdate(@Param("project") String project, @Param("version") String version, @Param("issue") String issueName, @Param("status") String status, @FormGroup("issue") Issue newIssue, Navigator nav) {
		Issue oldIssue = contentSource.getContent(project, version, issueName);
		oldIssue.setProject(project);
		oldIssue.setVersion(version);

		newIssue.setType(oldIssue.getType());
		State s = State.valueOf(status); // TODO: Status是枚举，单例；一处setTime改变，其余getTime也变
//		s.setTime(System.currentTimeMillis());
		List<State> statusList = oldIssue.getStatus();
		if (statusList.get(statusList.size() - 1) != s) {
		    statusList.add(s);
		}
		newIssue.setStatus(statusList);
		newIssue.setProject(project);
		newIssue.setVersion(version);

		boolean result = contentSource.updateContent(oldIssue, newIssue);

		nav.redirectTo("app1Link").withTarget("version").withParameter("project", project).withParameter("version", version);
	}
}
