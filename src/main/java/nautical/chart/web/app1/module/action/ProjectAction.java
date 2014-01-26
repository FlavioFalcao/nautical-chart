package nautical.chart.web.app1.module.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import nautical.chart.web.ui.datasource.ProjectSource;
import nautical.chart.web.ui.datasource.VersionSource;
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

    public void doAdd(@FormGroup("project") Project project, Navigator nav) {
        project.setBornTime(Project.SDF.format(new Date()));
        boolean result = projectSource.addProject(project);

        nav.redirectTo("app1Link").withTarget("index").withParameter("name", String.valueOf(result));
    }

    public void doDel(@Param("project") String project, Navigator nav) {
        Project oldProject = new Project();
        oldProject.setName(project);
        boolean result = projectSource.delProject(oldProject);
        nav.redirectTo("app1Link").withTarget("index").withParameter("name", String.valueOf(true));
    }

    public void doUpdate(@Param("oldProject") String oldProjectName, @Param("newProject") String newProjectName,
                         Navigator nav) {
        Project oldProject = new Project();
        oldProject.setName(oldProjectName);

        Project newProject = new Project();
        newProject.setName(newProjectName);

        boolean result = versionSource.updateProject(oldProject, newProject);
        nav.redirectTo("app1Link").withTarget("project").withParameter("name", newProjectName);
    }

    // attributes
    @Autowired
    private ProjectSource                 projectSource;
    @Autowired
    private VersionSource                 versionSource;
}
