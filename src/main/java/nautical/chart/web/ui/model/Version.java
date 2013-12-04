package nautical.chart.web.ui.model;

/**
 * 版本对象
 * 
 * @author Cheng Feng 2013-11-17 22:58
 */
public class Version {
	// setter & getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	// attributes
	private String name;
	private String project;
}
