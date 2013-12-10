package nautical.chart.web.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * @author Cheng Feng 2013-12-10 16:08:30
 */
public class UpdateVersion {

    public void execute(@Param("project") String project, @Param("version") String versionName, Context context) throws Exception {
    	context.put("project", project);
    	context.put("version", versionName);
    }
}
