package nautical.chart.web.app1.module.action;

import nautical.chart.web.ui.data.VersionSource;
import nautical.chart.web.ui.model.Version;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * 增加版本对应的action
 * 
 * @author Cheng Feng 2013-11-27 17:49:30
 */
public class VersionAction {
	@Autowired
	private VersionSource versionSource;

	public void doAdd(@Param("project") String project, @FormGroup("version") Version version, Navigator nav) {
		version.setProject(project);
		boolean result = versionSource.addVersion(version);
		nav.redirectTo("app1Link").withTarget("project").withParameter("name", project);
	}

	public void doDel(@Param("project") String project, @Param("version") String version, Navigator nav) {
		Version oldVersion = new Version();
		oldVersion.setName(version);
		oldVersion.setProject(project);
		boolean result = versionSource.delVersion(oldVersion);
		nav.redirectTo("app1Link").withTarget("project").withParameter("name", project);
	}
}
