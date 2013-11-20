package nautical.chart.web.ui.data;

/**
 * issue状态
 * 
 * @author Cheng Feng 2013-11-20 15:14:30
 */
public enum Status {

	TODO,	// 未开始
	DOING,	// 进行中
	DONE;	// 完成

	private long time;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
}
