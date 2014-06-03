package nautical.chart.web.ui.model;

/**
 * project、version、issue的状态
 * 
 * @author Cheng Feng 2013-11-20 15:14:30
 */
public enum State {

	TODO("TODO"),	// 未开始
	DOING("DOING"),	// 进行中
	DONE("DONE");	// 完成

	State(String state) {
	    this.state = state;
	}

	@Override
	public String toString() {
	    return state;
	}

	// attributes
	private String state;
}
