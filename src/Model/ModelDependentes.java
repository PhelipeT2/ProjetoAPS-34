package Model;

import java.util.Date;

public class ModelDependentes {

    private String DepName;
    private String DepSName;
    private Date DepAge;
    private String DepDoc;

    public ModelDependentes(String depName, String depSName, Date depAge, String depDoc) {
        DepName = depName;
        DepSName = depSName;
        DepAge = depAge;
        DepDoc = depDoc;
    }
    public String getDepName() {
        return DepName;
    }

    public void setDepName(String depName) {
        DepName = depName;
    }

    public String getDepSName() {
        return DepSName;
    }

    public void setDepSName(String depSName) {
        DepSName = depSName;
    }

    public Date getDepAge() {
        return DepAge;
    }

    public void setDepAge(Date depAge) {
        DepAge = depAge;
    }

    public String getDepDoc() {
        return DepDoc;
    }

    public void setDepDoc(String depDoc) {
        DepDoc = depDoc;
    }





}