package nautical.chart.web.app1.module.screen;

import nautical.chart.web.ui.datasource.ContentSource;
import nautical.chart.web.ui.model.Issue;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * 需求内容展示视图
 * 
 * @author Cheng Feng
 */
public class Content {
	@Autowired
	private ContentSource contentSource;

	public void execute(@Param("project") String project, @Param("version") String version, @Param("issue") String issueName, Context context) {
		context.put("project", project);
		context.put("version", version);
		context.put("issue", issueName);

		Issue issue = contentSource.getContent(project, version, issueName);
		context.put("content", issue);
	}
}
