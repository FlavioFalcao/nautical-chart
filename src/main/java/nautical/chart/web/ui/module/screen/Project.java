package nautical.chart.web.ui.module.screen;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nautical.chart.web.ui.data.VersionSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Context;

/**
 * 项目展示试图
 * 
 * @author Cheng Feng 2013-11-19 14:38:30
 */
public class Project {
    @Autowired
    private HttpServletRequest request;
	@Autowired
	private VersionSource versionSource;

	public void execute(Context context) {
		String projectName = (String) request.getParameter("name");
		List<String> versions = versionSource.listVersions(projectName);
		context.put("projectName", projectName);
		context.put("versions", versions);
	}
}
