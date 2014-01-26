package nautical.chart.web.ui.module.screen;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import nautical.chart.web.ui.datasource.ProjectSource;

import com.alibaba.citrus.turbine.Context;

/**
 * 主页对应逻辑(所有项目列表视图)
 * 
 * @author Cheng Feng 2013-11-19 16:25:30
 */
public class Default {
	@Autowired
	private ProjectSource projectSource;

	public void execute(Context context) {
		List<File> projects = projectSource.listProjects();
		context.put("projects", projects);
	}
}
