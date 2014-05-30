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
    private Project(){
    }

    public static Project who(String owner) {
        Project result = new Project();
        result.owner = owner;

        return result;
    }

    public Project create(String name) {
        this.name = name;
        this.bornTime = SDF.format(new Date());
        return this;
    }

    public Project document(String document) {
        this.document = document;
        return this;
    }

    // getter
    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getDocument() {
        return document;
    }

    public String getBornTime() {
        return bornTime;
    }

    // attributes
    public static final String           NAME_SEPARATOR = "_";
    public static final SimpleDateFormat SDF            = new SimpleDateFormat("yyyyMMddHHmmss");
    private String                       name;
    private String                       owner;
    private String                       document;
    private String                       bornTime;
}
