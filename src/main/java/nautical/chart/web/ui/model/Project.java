package nautical.chart.web.ui.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目对象
 * 
 * @author Cheng Feng 2013-11-17 22:57
 */
public class Project {

    // constructor
    public Project(){
        name = "DEFAULT";
        owner = "DEFAULT";
        bornTime = SDF.format(new Date());
    }

    // constructor
    public Project(String fileName){
        String contents[] = fileName.split(NAME_SEPARATOR);
        name = contents[0];
        owner = contents[1];
        bornTime = contents[2];
    }

    // setter & getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBornTime() {
        return bornTime;
    }

    public void setBornTime(String bornTime) {
        this.bornTime = bornTime;
    }

    // attributes
    public static final String           NAME_SEPARATOR = "_";
    public static final SimpleDateFormat SDF            = new SimpleDateFormat("yyyyMMddHHmmss");
    private String                       name;
    private String                       owner;
    private String                       bornTime;
}
