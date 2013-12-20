package nautical.chart.web.ui.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nautical.chart.web.ui.utils.Transformer;

/**
 * 问题对象
 * 
 * @author Cheng Feng 2013-11-17 22:59:30
 */
public class Issue {
	public void addStatus(Status status) {
		this.status.add(status);
	}

	public static List<Status> string2Status(String content) {
		List<Status> result = new ArrayList<Status>();

		String tmps[] = content.trim().split(":");
		for (String tmp : tmps) {
			String timeAndStatus[] = tmp.split("-");
			if (timeAndStatus.length == 2) {
				Status tmpStatus = Status.valueOf(timeAndStatus[1]);
				long time = Transformer.stringDate2Long(timeAndStatus[0]);
				tmpStatus.setTime(time);
				result.add(tmpStatus);
			}
		}

		return result;
	}

	public static String status2String(List<Status> status) {
		StringBuilder sBuilder = new StringBuilder();

		for (Status s : status) {
			String prefix = DATA_FORMAT.format(new Date(s.getTime()));
			String suffix = s.name();
			sBuilder.append(":").append(prefix).append("-").append(suffix);
			
		}

		return sBuilder.toString().substring(1);
	}

	// setter & getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	// attributes
	private static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
	private String name;
	private String description;
	private Type type;
	private String originator;
	private String owner;
	private List<Status> status = new ArrayList<Status>();
	private String project;
	private String version;
}
