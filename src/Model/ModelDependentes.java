package Model;

import java.util.Date;

public class ModelDependentes {
    private String DepName, DepDoc;
    private Date DepAge;

    private String DepName2, DepDoc2;
    private Date DepAge2;

    public ModelDependentes(String depName, Date depAge, String depDoc,
                            String depName2, Date depAge2, String depDoc2) {
        DepName = depName;
        DepAge = depAge;
        DepDoc = depDoc;

        DepName2 = depName2;
        DepAge2 = depAge2;
        DepDoc2 = depDoc2;
    }
    public String getDepName() { return DepName; }
    public void setDepName(String depName) { DepName = depName; }
    public Date getDepAge() { return DepAge; }
    public void setDepAge(Date depAge) { DepAge = depAge; }
    public String getDepDoc() { return DepDoc; }
    public void setDepDoc(String depDoc) { DepDoc = depDoc; }

    public String getDepName2() { return DepName2; }
    public void setDepName2(String depName2) { DepName2 = depName2; }
    public Date getDepAge2() { return DepAge2; }
    public void setDepAge2(Date depAge2) { DepAge2 = depAge2; }
    public String getDepDoc2() { return DepDoc2; }
    public void setDepDoc2(String depDoc2) { DepDoc2 = depDoc2; }
}