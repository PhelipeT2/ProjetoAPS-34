package Model;

import java.sql.Date;

public class ModelCadastro {
    private String Name, SName, Doc, Email;
    private Date Age;
    private int Tel;

    public void ModelCadastro(String Name, String SName, String Doc, String Email, Date Age, int Tel){
        this.Name = Name;
        this.SName = SName;
        this.Doc = Doc;
        this.Email = Email;
        this.Age = Age;
        this.Tel = Tel;
    }

    public String getName(){
        return Name;
    }
    public String getSName(){
        return SName;
    }
    public String getDoc(){
        return Doc;
    }
    public String getEmail(){
        return Email;
    }
    public Date getAge(){return Age;}
    public int getTel(){
        return Tel;
    }
}
