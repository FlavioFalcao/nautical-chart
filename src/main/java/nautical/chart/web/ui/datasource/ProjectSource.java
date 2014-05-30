package nautical.chart.web.ui.datasource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import nautical.chart.web.ui.model.Project;
import nautical.chart.web.ui.utils.FileHelper;

/**
 * 项目数据源
 * 
 * @author Cheng Feng 2013-11-18 22:30
 */
public class ProjectSource {

    // init method
    public void init() {
        if (!location.endsWith(File.separator)) { // 在location后面补齐/，例如从/home/admin/data变成/home/admin/data/
            location += File.separator;
        }

        File tmp = new File(location);
        if (tmp.exists() && tmp.isDirectory()) {
            dataDir = tmp;
        } else {
            dataDir = null;
        }
    }

    public List<File> listProjects() {
        if (dataDir == null) {
            return new ArrayList<File>();
        } else {
            List<File> result = new ArrayList<File>();

            File tmps[] = dataDir.listFiles();
            for (File tmp : tmps) {
                if (tmp.isDirectory()) {
                    result.add(tmp);
                }
            }

            return result;
        }
    }

    /**
     * 新增项目
     * 
     * @param projectName 项目名称
     * @return true: 新增项目成功; false: 新增项目失败
     */
    public boolean addProject(Project newProject) {
        String newProjectName = location + newProject.getName() + Project.NAME_SEPARATOR + newProject.getOwner()
                                + Project.NAME_SEPARATOR + newProject.getBornTime();
        File project = new File(newProjectName);

        if (project.exists() && project.isDirectory()) {
            return true;
        } else if (!project.exists()) {
            return project.mkdirs();
        } else {
            return false;
        }
    }

    public boolean delProject(Project oldProject) {
        File project = new File(dataDir.getAbsolutePath() + File.separator + oldProject.getName());

        if (project.exists()) {
            return FileHelper.delFile(project);
        } else {
            return true;
        }
    }

    // getter & setter
    public void setLocation(String location) {
        this.location = location;
    }

    public File getDataDir() {
        return dataDir;
    }

    // attributes
    private String location;
    private File   dataDir;
}
