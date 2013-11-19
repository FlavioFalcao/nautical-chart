package nautical.chart.web.ui.module.screen;

import org.springframework.beans.factory.annotation.Autowired;
import nautical.chart.web.ui.data.ProjectSource;
import com.alibaba.citrus.turbine.Context;

/**
 * 主页对应逻辑
 * 
 * @author Cheng Feng
 */
public class Default {
	@Autowired
	private ProjectSource projectSource;

	public void execute(Context context) {
		context.put("location", projectSource.listProjects());
	}
}
