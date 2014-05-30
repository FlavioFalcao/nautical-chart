package nautical.chart.web.app1.module.screen;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nautical.chart.web.ui.datasource.ProjectSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

/**
 * 测试Ajax
 * 
 * @author Cheng Feng
 */
public class Ajax {

    public void execute() throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String type = request.getParameter("type");
        if (PROJECTS.equals(type)) {
            List<String> result = new ArrayList<String>();
            List<File> projectDirs = projectSource.listProjects();
            for (File projectDir : projectDirs) {
                result.add(projectDir.getName());
            }
            out.print(JSON.toJSONString(result));
        } else if (VERSIONS.equals(type)) {
            List<nautical.chart.web.ui.model.Version> list = new ArrayList<nautical.chart.web.ui.model.Version>();
            nautical.chart.web.ui.model.Version v1 = new nautical.chart.web.ui.model.Version("v1", "p1");
            list.add(v1);
            nautical.chart.web.ui.model.Version v2 = new nautical.chart.web.ui.model.Version("v2", "p1");
            list.add(v2);
            nautical.chart.web.ui.model.Version v3 = new nautical.chart.web.ui.model.Version("v3", "p1");
            list.add(v3);
            out.print(JSON.toJSONString(list));
        } else if (ISSUES.equals(type)) {
            List<nautical.chart.web.ui.model.Issue> list = new ArrayList<nautical.chart.web.ui.model.Issue>();
            nautical.chart.web.ui.model.Issue i1 = new nautical.chart.web.ui.model.Issue("i1", "v1");
            list.add(i1);
            nautical.chart.web.ui.model.Issue i2 = new nautical.chart.web.ui.model.Issue("i2", "v1");
            list.add(i2);
            nautical.chart.web.ui.model.Issue i3 = new nautical.chart.web.ui.model.Issue("i3", "v1");
            list.add(i3);
            out.print(JSON.toJSONString(list));
        }
    }

    // attributes
    private static final String PROJECTS = "projects";
    private static final String VERSIONS = "versions";
    private static final String ISSUES   = "issues";
    @Autowired
    private HttpServletRequest  request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private ProjectSource       projectSource;
}
