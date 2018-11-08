package Model;

import java.util.Date;

public class ModelDependentes {
    private String DepName, DepDoc;
    private Date DepAge;

    public ModelDependentes(String depName, Date depAge, String depDoc) {
        DepName = depName;
        DepAge = depAge;
        DepDoc = depDoc;
    }
    public String getDepName() { return DepName; }
    public void setDepName(String depName) { DepName = depName; }
    public Date getDepAge() { return DepAge; }
    public void setDepAge(Date depAge) { DepAge = depAge; }
    public String getDepDoc() { return DepDoc; }
    public void setDepDoc(String depDoc) { DepDoc = depDoc; }

}