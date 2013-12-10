package nautical.chart.web.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * @author Cheng Feng 2013-12-10 16:37:30
 */
public class UpdateProject {

    public void execute(@Param("project") String project, Context context) throws Exception {
    	context.put("project", project);
    }
}
