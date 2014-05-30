package nautical.chart.web.app1.module.action;

import nautical.chart.web.ui.datasource.ProjectSource;
import nautical.chart.web.ui.model.Setting;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;

/**
 * setting.vm对应的后台逻辑
 * 
 * @author Cheng Feng Jan 16, 2014 5:43:44 PM
 */
public class SettingAction {
    @Autowired
    private ProjectSource projectSource;

    public void doAdd(@FormGroup("setting") Setting setting, Navigator nav) {
        nav.redirectTo("app1Link").withTarget("index");
    }
}
