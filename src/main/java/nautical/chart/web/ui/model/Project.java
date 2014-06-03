package nautical.chart.web.ui.model;

import java.text.SimpleDateFormat;

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

    public Project when(String born) {
        this.born = born;
        return this;
    }

    public Project create(String name) {
        this.name = name;
        return this;
    }

    public Project descript(String description) {
        this.description = description;
        return this;
    }

    public Project document(String document) {
        this.document = document;
        return this;
    }

    public Project state(State state) {
        this.state = state;
        return this;
    }

    // getter
    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public String getDocument() {
        return document;
    }

    public String getBorn() {
        return born;
    }

    public State getState() {
        return state;
    }

    // attributes
    public static final String           NAME_SEPARATOR = "_";
    public static final SimpleDateFormat SDF            = new SimpleDateFormat("yyyyMMddHHmmss");
    private String                       name;
    private String                       owner;
    private String                       description;
    private String                       document;
    private String                       born;
    private State                        state;
}
