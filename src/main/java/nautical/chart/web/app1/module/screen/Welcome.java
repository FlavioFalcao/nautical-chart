package nautical.chart.web.app1.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

/**
 * 欢迎页面
 * 
 * @author Cheng Feng
 */
public class Welcome {
    public void execute(@Param("name") String name, Context context) {
        context.put("name", name);
    }
}
