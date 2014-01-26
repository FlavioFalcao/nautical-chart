package nautical.chart.web.app1.module.screen;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nautical.chart.web.ui.datasource.VersionSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;

/**
 * 项目展示视图
 * 
 * @author Cheng Feng 2013-11-19 14:38:30
 */
public class Project {
    @Autowired
    private HttpServletRequest request;
	@Autowired
	private VersionSource versionSource;

	public void execute(Context context) {
		String project = request.getParameter("name");
		context.put("project", project);

		List<File> versions = versionSource.listVersions(project);
		context.put("versions", versions);
	}
}
