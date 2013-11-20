package nautical.chart.web.ui.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nautical.chart.web.ui.data.Status;
import nautical.chart.web.ui.utils.Transformer;

/**
 * 问题对象
 * 
 * @author Cheng Feng 2013-11-17 22:59:30
 */
public class Issue {
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

		Collections.sort(result, new Comparator<Status>() {
			@Override
			public int compare(Status s1, Status s2) {
				if (s1.getTime() > s2.getTime()) {
					return 1;
				} else if (s1.getTime() < s2.getTime()) {
					return -1;
				} else {
				    return 0;
				}
			}
		});

		return result;
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

	// attributes
	private String name;
	private String description;
	private Type type;
	private String originator;
	private String owner;
	private List<Status> status;
}
