package nautical.chart.web.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * 增加需求页面的逻辑
 * 
 * @author Cheng Feng 2013-12-07 11:28:30
 */
public class AddIssue {
    public void execute(@Param("project") String project, @Param("version") String version, Context context) throws Exception {
    	context.put("project", project);
    	context.put("version", version);
    }
}
