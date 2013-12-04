package nautical.chart.web.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * 增加版本页面的逻辑
 * 
 * @author Cheng Feng 2013-12-04 23:12:30
 */
public class AddVersion {
    public void execute(@Param("project") String project, Context context) throws Exception {
    	context.put("project", project);
    }
}
