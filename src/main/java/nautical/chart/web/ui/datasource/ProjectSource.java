package nautical.chart.web.ui.datasource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nautical.chart.web.nc.Constants;
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
        String newProjectName = location + newProject.getName();
        File project = new File(newProjectName);

        if (project.exists() && project.isDirectory()) {
            return true;
        } else if (!project.exists()) {
            return project.mkdirs();
        } else {
            return false;
        }
    }

    public boolean addProjectManifest(Project newProject) {
        String newProjectManifestName = location + newProject.getName() + File.separator + Constants.MANIFEST;
        File manifest = new File(newProjectManifestName);

        if (manifest.exists() && manifest.isFile()) {
            return true;
        } else if (!manifest.exists()) {
            FileWriter writer = null;
            try {
                boolean result = manifest.createNewFile();
                if (!result) {
                    // TODO: LOG
                    return result;
                }

                writer = new FileWriter(manifest, true);
                writer.write("Owner:" + newProject.getOwner() + "\n");
                writer.write("Description:" + newProject.getDescription() + "\n");
                writer.write("Document:" + newProject.getDocument() + "\n");
                writer.write("Born:" + newProject.getBorn() + "\n");
                writer.write("State:" + newProject.getState() + "_" + newProject.getBorn());

                return true;
            } catch (Throwable t) {
                // TODO: LOG
                return false;
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        // DO NOTHING
                    }
                }
            }
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
