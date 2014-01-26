package nautical.chart.web.app1.module.screen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import nautical.chart.web.ui.datasource.ProjectSource;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;

/**
 * 主页对应逻辑(所有项目列表视图)
 * 
 * @author Cheng Feng 2013-11-19 16:25:30
 */
public class Default {

    public void execute(Context context, Navigator nav) {
        List<File> projects = projectSource.listProjects();
        List<nautical.chart.web.ui.model.Project> viewProject = new ArrayList<nautical.chart.web.ui.model.Project>();
        for (File project : projects) {
            viewProject.add(new nautical.chart.web.ui.model.Project(project.getName()));
        }

        context.put("projects", viewProject);
    }

    // attributes
    @Autowired
    private ProjectSource projectSource;
}
