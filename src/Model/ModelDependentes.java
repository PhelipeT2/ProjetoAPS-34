package Model;

import java.util.Date;

public class ModelDependentes {

    private String DepName;
    private String DepSName;
    private Date DepAge;
    private int DepDoc;
    private int QtdAdulto;
    private int QtdCrianca;


    public ModelDependentes(int DepDoc, int QtdAdulto) {
        this.DepName = DepName;
        this.DepSName = DepSName;
        this.DepAge = DepAge;
        this.DepDoc = DepDoc;
        this.QtdAdulto = QtdAdulto;
        this.QtdCrianca = QtdCrianca;
    }

    public String getDepName() {
        return DepName;
    }

    public String getDepSName() {
        return DepSName;
    }

    public Date getDepAge() {
        return DepAge;
    }

    public int getDepDoc() {
        return DepDoc;
    }

    public int getQtdAdulto() {
        return QtdAdulto;
    }

    public int getQtdCrianca() { return QtdCrianca; }

}