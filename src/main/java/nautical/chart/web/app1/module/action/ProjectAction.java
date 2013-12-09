package nautical.chart.web.app1.module.action;

import org.springframework.beans.factory.annotation.Autowired;

import nautical.chart.web.ui.data.ProjectSource;
import nautical.chart.web.ui.model.Project;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * 增加项目对应的action
 * 
 * @author Cheng Feng 2013-11-26 15:13:30
 */
public class ProjectAction {
	@Autowired
	private ProjectSource projectSource;

    public void doAdd(@FormGroup("project") Project project, Navigator nav) {
    	boolean result = projectSource.addProject(project);
        nav.redirectTo("app1Link").withTarget("index1").withParameter("name", String.valueOf(result));
    }

    public void doDel(@Param("project") String project, Navigator nav) {
    	Project oldProject = new Project();
    	oldProject.setName(project);
    	boolean result = projectSource.delProject(oldProject);
        nav.redirectTo("app1Link").withTarget("index1").withParameter("name", String.valueOf(true));
    }
}
