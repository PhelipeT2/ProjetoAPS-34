package Model;

import java.time.LocalDate;

public class ModelDependentes {
    private String DepName, DepDoc;
    private LocalDate DepAge;



    public ModelDependentes(String depName, LocalDate depAge, String depDoc) {
        DepName = depName;
        DepAge = depAge;
        DepDoc = depDoc;
    }
    public String getDepName() { return DepName; }
    public void setDepName(String depName) { DepName = depName; }
    public LocalDate getDepAge() { return DepAge; }
    public void setDepAge(LocalDate depAge) { DepAge = depAge; }
    public String getDepDoc() { return DepDoc; }
    public void setDepDoc(String depDoc) { DepDoc = depDoc; }


}