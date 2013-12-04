package nautical.chart.web.ui.module.action;

import nautical.chart.web.ui.model.Project;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;

/**
 * 增加项目对应的action
 * 
 * @author Cheng Feng 2013-11-26 15:13:30
 */
public class ProjectAction {
    public void doAdd(@FormGroup("project") Project project, Navigator nav) {
        String name = project.getName();
        System.out.println(name);
        nav.redirectTo("uiLink").withTarget("project").withParameter("name", "nautical-chart");
    }
}
