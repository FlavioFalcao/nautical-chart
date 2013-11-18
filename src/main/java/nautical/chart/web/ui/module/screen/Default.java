package nautical.chart.web.ui.module.screen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import nautical.chart.web.ui.data.DataSource;

import com.alibaba.citrus.turbine.Context;

/**
 * 主页对应逻辑
 * 
 * @author Cheng Feng
 */
public class Default {
	@Autowired
	private DataSource dataSource;

	public void execute(Context context) {
		List<String> location = new ArrayList<String>();
		location.add("Here");
		location.add(dataSource.getLocation());
		context.put("location", location);
	}
}
